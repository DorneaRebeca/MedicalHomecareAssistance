import { Component, OnInit } from '@angular/core';
import {Patient} from '../model/patient';
import {Caregiver} from '../model/caregiver';
import {DoctorService} from '../services/doctor.service';
import {Doctor} from '../model/doctor';
import {MedicationPlan} from '../model/medication-plan';
import {Medication} from '../model/medication';
import {Pill} from '../model/pill';
import {Router} from '@angular/router';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  patients: Patient[] = [];
  caregivers: Caregiver[] = [];
  patientToBeCreated: Patient = new Patient();
  patientToBeUpdated: Patient = new Patient();
  searchPatient: Patient = new Patient();
  caregiverToBeCreated: Caregiver = new Caregiver();
  caregiverToBeUpdated: Caregiver = new Caregiver();
  loggedDoctor: Doctor = new Doctor();
  newMedicationPlan: MedicationPlan = new MedicationPlan();
  medications: Medication[] = [];
  medicationToBeCreated: Medication = new Medication();
  medicationToBeUpdated: Medication = new Medication();
  newPill: Pill = new Pill();
  patientDetails: string;
  intakeFrom : number;
  intakeTo : number;


  constructor(
    private doctorService: DoctorService,
    private router : Router
  ) {}

  ngOnInit() {

    this.doctorService.getPatients().subscribe(
      response => this.patients = response,
    );
    this.doctorService.getCaregivers().subscribe(
      response => this.caregivers = response,
    );
    this.doctorService.getMedications().subscribe(
      response => this.medications = response,
    );
  }

  findPatientById(patient: Patient): void {
    this.doctorService.getPatientById(patient.id)
      .subscribe(
        data => {
          this.searchPatient = data;
          this.getPatientDetails();
        });
  }

  deletePatient(patient: Patient): void {
    this.doctorService.deletePatient(patient)
      .subscribe( data => {
        this.patients = this.patients.filter(u => u !== patient);
      });
  }
  createPatient(): void {
    this.doctorService.createPatient(this.patientToBeCreated)
      .subscribe( data => {
        this.patients.push(this.patientToBeCreated);
        alert('Patient created successfully');
      });
  }
  createCaregiver(): void {
    this.doctorService.createCaregiver(this.caregiverToBeCreated)
      .subscribe( data => {
        this.caregivers.push(this.caregiverToBeCreated);
        alert('Caregiver created successfully');
      });
  }
  deleteCaregiver(caregiver: Caregiver): void {
    this.doctorService.deleteCaregiver(caregiver)
      .subscribe( data => {
        this.caregivers = this.caregivers.filter(u => u !== caregiver);
      });
  }
  changePatientCaregiver(caregiver: Caregiver) {
    this.patientToBeUpdated.caregiver.id = caregiver.id;
  }

  updatePatient(patient: Patient) {
    this.doctorService.updatePatient(patient)
      .subscribe( data => {
        alert('Patient updated successfully');
      });
    }

  addPatientToCaregiver(patient: Patient) {
    this.caregiverToBeUpdated.patients.push(patient);
  }
  updateCaregiver(caregiver: Caregiver) {
    this.doctorService.updateCaregiver(caregiver)
      .subscribe( data => {
        alert('Caregiver updated successfully');
      });
  }

  addPill() {
    this.newPill.intakeInterval = this.intakeFrom + "-" + this.intakeTo;
    alert('Pill added ' + this.newPill.medication.id);
    this.newMedicationPlan.pills.push(this.newPill);
  }

  createMedicationPlan() {
    alert(this.loggedDoctor.id);
      this.newMedicationPlan.doctor = this.loggedDoctor;
      this.doctorService.createMedicationPlan(this.newMedicationPlan)
        .subscribe( data => {
          alert('Medication Plan successfully created');
        });
  }

  createMedication(): void {
    this.doctorService.createMedication(this.medicationToBeCreated)
      .subscribe( data => {
        this.medications.push(this.medicationToBeCreated);
        alert('Medication created successfully');
      });
  }
  deleteMedication(medication: Medication): void {
    this.doctorService.deleteMedication(medication)
      .subscribe( data => {
        this.medications = this.medications.filter(u => u !== medication);
      });
  }
  updateMedication(medication: Medication) {
    this.doctorService.updateMedication(medication)
      .subscribe( data => {
        alert('Medication updated successfully');
      });
  }

  getPatientDetails() {
    this.patientDetails = 'Patient number : ' + this.searchPatient.id +
      '\n Name : ' + this.searchPatient.name + '\n' +
      'Address : ' + this.searchPatient.address + '\n' +
      'Email : ' + this.searchPatient.email + '\n' +
      'Birth Date : ' + this.searchPatient.birthDate + '\n' +
      'Gender : ' + this.searchPatient.gender + '\n' +
      'Caregiver : ' + this.searchPatient.caregiver.name + '\n' +
      'MedicationPlans : \n';
    if (this.searchPatient.medicalRecord !== []) {
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.searchPatient.medicalRecord.length; i++) {
        this.patientDetails += 'plan number : ' + this.searchPatient.medicalRecord[i].id
          + '\n Start Date : ' + this.searchPatient.medicalRecord[i].startDate +
          +'\n End Date : ' + this.searchPatient.medicalRecord[i].endDate +
          +'\n Responsible doctor : ' + this.searchPatient.medicalRecord[i].doctor.email
          + '\n Pills : \n';
        for (let j = 0; j < this.searchPatient.medicalRecord.length; j++) {
          this.patientDetails += 'Medication : ' + this.searchPatient.medicalRecord[i].pills[j].medication.name +
            '\n Intake interval : ' + this.searchPatient.medicalRecord[i].pills[j].intakeInterval + ' hours\n';
        }
      }
    }
  }

  goToDetails(patient: Patient) : void {
    this.router.navigateByUrl('/patientDetails', { queryParams: { patientId: patient.id } });
  }

}

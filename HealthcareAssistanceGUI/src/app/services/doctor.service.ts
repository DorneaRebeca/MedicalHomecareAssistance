import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Patient} from '../model/patient';
import {Caregiver} from '../model/caregiver';
import {MedicationPlan} from '../model/medication-plan';
import {Medication} from '../model/medication';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  usersURL = 'https://localhost:8080/doctor';

  constructor(private http: HttpClient) {
  }

  getPatients() {
    return this.http.get<Patient[]>(this.usersURL + '/allPatients');
  }
  getCaregivers() {
    return this.http.get<Caregiver[]>(this.usersURL + '/allCaregivers');
  }
  getMedications() {
    return this.http.get<Medication[]>(this.usersURL + '/allMedications');
  }

  getPatientById(id: number) {
    return this.http.get<Patient>(this.usersURL + '/patient/' + id);
  }
  public deletePatient(patient: Patient) {
    return this.http.delete<Patient>(this.usersURL + '/patient/delete/' + patient.id);
  }

  public createPatient(patient: Patient) {
    return this.http.post<Patient>(this.usersURL + '/newPatient' , patient);
  }
  public updatePatient(patient: Patient) {
    return this.http.put<Patient>(this.usersURL + '/updatePatient' , patient);
  }


  public createCaregiver(caregiver: Caregiver) {
    return this.http.post<Caregiver>(this.usersURL + '/newCaregiver' , caregiver);
  }

  public deleteCaregiver(caregiver: Caregiver) {
    return this.http.delete<Caregiver>(this.usersURL + '/caregiver/delete/id/' + caregiver.id);
  }


  public updateCaregiver(caregiver: Caregiver) {
    alert('Face updaaate');
    return this.http.put<Caregiver>(this.usersURL + '/updateCaregiver' , caregiver);
  }

  public createMedicationPlan(medicationPlan: MedicationPlan) {
    return this.http.post<MedicationPlan>(this.usersURL + '/newMedicationPlan' , medicationPlan);
  }

  public createMedication(medication: Medication) {
    return this.http.post<Medication>(this.usersURL + '/newMedication' , medication);
  }

  public deleteMedication(medication: Medication) {
    return this.http.delete<Medication>(this.usersURL + '/medication/idToDelete/' + medication.id);
  }


  public updateMedication(medication: Medication) {
    alert('za id  ' + medication.id );
    return this.http.put<Medication>(this.usersURL + '/updateMedication' , medication);
  }

}

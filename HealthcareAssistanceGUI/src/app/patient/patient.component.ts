import { Component, OnInit } from '@angular/core';
import {PatientService} from '../services/patient.service';
import {Patient} from '../model/patient';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  loggedPatient: Patient = new Patient();

  constructor(
    private patientService: PatientService
  ) { }

  ngOnInit() {
    this.patientService.getUserById(8).subscribe(data => {
      this.loggedPatient = data;
      alert(this.loggedPatient.medicalRecord[5].pills[0].medication.name)
    });
  }



}

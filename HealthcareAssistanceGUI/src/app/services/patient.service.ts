import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Patient} from '../model/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  usersURL = 'https://localhost:8080/patient';

  constructor(private http: HttpClient) {
  }

  getUserById(id: number) {
    return this.http.get<Patient>(this.usersURL + '/' + id);
  }
  public deletePatient(patient: Patient) {
    return this.http.delete<Patient>(this.usersURL + '/patient/delete/' + patient.id);
  }

  public createPatient(patient: Patient) {
    return this.http.post<Patient>(this.usersURL + '/newPatient' , patient);
  }

}

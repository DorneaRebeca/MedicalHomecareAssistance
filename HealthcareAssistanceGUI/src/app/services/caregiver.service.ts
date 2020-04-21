import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Caregiver} from '../model/caregiver';
import {Recommendation} from '../model/recommendation';

@Injectable({
  providedIn: 'root'
})
export class CaregiverService {

  usersURL = 'https://localhost:8080/caregiver';
  recommendationURL = 'http://localhost:8082/soapDoctor';

  constructor(private http: HttpClient) {
  }

  getUserById(id: number) {
    return this.http.get<Caregiver>(this.usersURL + '/' + id);
  }

  findByEmail(email: string) {
    return this.http.get<Caregiver>(this.usersURL + '/email/' + email);
  }

  getRecommendations(id: number) {
    return this.http.get<Recommendation[]>(this.recommendationURL + '/recommendations/' + id);
  }


}

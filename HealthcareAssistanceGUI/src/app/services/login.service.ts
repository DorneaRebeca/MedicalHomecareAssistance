import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Caregiver} from '../model/caregiver';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  usersURL = 'https://localhost:8080/login';

  constructor(private http: HttpClient) {
  }

  login(email: string, password: string, userType: number) {
    return this.http.post<Object>(this.usersURL + '/submit' , {
      email: 'cm@yahoo.com',
      password: 'pass',
      choice: 1
    });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {NgxXml2jsonService} from 'ngx-xml2json';
import {Patient} from '../model/patient';
import {MonitoredData} from '../model/monitored-data';
import {MonitoredPill} from '../model/monitored-pill';
import {Recommendation} from '../model/recommendation';
import {ActivityStatus} from '../model/activity-status';


@Injectable({
  providedIn: 'root'
})

export class PatientDetailsService {

  usersURL = 'http://localhost:8082/soapDoctor';


  constructor(private http: HttpClient
              ) {

  }

  getPatientById(id: number) {
    return this.http.get<Patient>(this.usersURL + '/patient/' + id);
  }

  getActivities( id : number) {
    return this.http.get<MonitoredData[]>(this.usersURL + '/patient/' + id + "/activities");
  }

  getMonitoredPills(id : number, date: string) {
    return this.http.get<MonitoredPill[]>(this.usersURL + '/pills/patient/' + id  + '/on/' + date);
  }

  getActivityOn(date : string, id : number) {
    return this.http.get<ActivityStatus[]>(this.usersURL + '/patient/' + id + "/activity/date/" + date
      );
  }

  public newRecommendation(recommendation : Recommendation) {
    alert("Here in service");
    return this.http.post<Recommendation>(this.usersURL + '/recommendation' ,recommendation);
  }



}

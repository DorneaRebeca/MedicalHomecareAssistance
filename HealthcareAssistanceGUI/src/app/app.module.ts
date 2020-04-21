import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DoctorComponent } from './doctor/doctor.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { PatientComponent } from './patient/patient.component';
import { CaregiverComponent } from './caregiver/caregiver.component';
import { LoginComponent } from './login/login.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import {GoogleChartComponent, GoogleChartsModule} from 'angular-google-charts';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DoctorComponent,
    PatientComponent,
    CaregiverComponent,
    LoginComponent,
    PatientDetailsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    GoogleChartsModule,
    RouterModule.forRoot([
      {
        path: 'doctor',
        component: DoctorComponent
      },
      {
        path: 'patient',
        component: PatientComponent
      },
      {
        path: 'caregiver',
        component: CaregiverComponent
      },
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'patientDetails',
        component: PatientDetailsComponent
      }
    ]),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
,
    exports: [ RouterModule ]
})
export class AppModule { }

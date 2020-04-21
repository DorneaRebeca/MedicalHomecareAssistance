import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Patient} from '../model/patient';
import {PatientDetailsService} from '../services/patient-details.service';
import {MonitoredData} from '../model/monitored-data';
import {MonitoredPill} from '../model/monitored-pill';
import {GoogleChartComponent, GoogleChartsModule} from 'angular-google-charts';
import {Caregiver} from '../model/caregiver';
import {CaregiverService} from '../services/caregiver.service';
import {DoctorService} from '../services/doctor.service';
import {Recommendation} from '../model/recommendation';
//declare var google: any;

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  patient : Patient = null;
  activities : MonitoredData[] = [];
  notTakenPills : MonitoredPill[] = [];
  notTakenPillsDate : string;

  title1 : string = 'Activity chart on 28-11-2011';
  title2 : string = 'Activity chart on 29-11-2011';
  title3 : string = 'Activity chart on 30-11-2011';
  chartType : string = 'PieChart';
  columnNames : string[] = ["ActivityName", "ActivityTime"];
  recommendation : Recommendation = new Recommendation();
  message : string = '';

  chartData1  = [];
  chartData2  = [];
  chartData3  = [];
  caregivers : Caregiver[] = [];

  options = {
     //is3D: true
  };
  hidden : boolean = true;

  constructor( private patientDetailsService : PatientDetailsService,
              private doctorService : DoctorService
              ) {

  }

  ngOnInit() {

    this.getPatientDetails(5);
    this.getPatientActivities();

    this.doctorService.getCaregivers().subscribe(
      response => this.caregivers = response,
    );
    this.chartData1 = this.setActivityChartDetails('2011-11-28');
    this.chartData2 = this.setActivityChartDetails('2011-11-29');
    this.chartData3 = this.setActivityChartDetails('2011-11-30');

    console.log(this.chartData1);
    console.log(this.chartData2);
    console.log(this.chartData3);
  }

  getPatientDetails(id : number) : void {
    this.patientDetailsService.getPatientById(id)
      .subscribe(
        res => this.patient = res
      )
  }

  getPatientActivities() : void{

       this.patientDetailsService.getActivities(5).subscribe(
        rez => this.activities = rez
       );

  }

  getPatientPills() : void{

    this.patientDetailsService.getMonitoredPills(5, this.notTakenPillsDate).subscribe(
      rez => this.notTakenPills = rez
    );
    this.hidden = false;

  }

  setActivityChartDetails(date : string) : (string | number)[][] {

    let chartData = [ ['Leaving' , 0],
      ['Toileting', 0],
      ['Showering', 0],
      ['Sleeping', 0],
      ['Breakfast', 0],
      ['Lunch', 0],
      ['Dinner', 0],
      ['Snack', 0],
      ['Spare_Time/TV', 0],
      ['Grooming', 0],
    ];
    this.patientDetailsService.getActivityOn(date, 5).subscribe(
      activities => {
        activities.forEach(
          a => {
            console.log(
              a.activity + ' ' + a.time
            );
            switch (a.activity) {
              case 'Leaving' : {
                chartData[0][1] = <number> chartData[0][1] + a.time;
                break;
              }
              case 'Toileting' : {
                chartData[1][1] = <number> chartData[1][1] + a.time;
                break;
              }
              case 'Showering' : {
                chartData[2][1] = <number> chartData[2][1] + a.time;
                break;
              }
              case 'Sleeping' : {
                chartData[3][1] = <number> chartData[3][1] + a.time;
                break;
              }
              case 'Breakfast' : {
                chartData[4][1] = <number> chartData[4][1] + a.time;
                break;
              }
              case 'Lunch' : {
                chartData[5][1] = <number> chartData[5][1] + a.time;
                break;
              }
              case 'Dinner' : {
                chartData[6][1] = <number> chartData[6][1] + a.time;
                break;
              }
              case 'Snack' : {
                chartData[7][1] = <number> chartData[7][1] + a.time;
                break;
              }
              case 'Spare_Time/TV' : {
                chartData[8][1] = <number> chartData[8][1] + a.time;
                break;
              }
              case 'Grooming' : {
                chartData[9][1] = <number> chartData[9][1] + a.time;
                break;
              }
              default :
                break;
            }
          }
        );
      });
    console.log(chartData);
    return chartData;
  }


  setRecommendationCaregiver(caregiver: Caregiver) : void{
    this.recommendation.caregiver.id = caregiver.id;
  }

  writeRecommendation() : void {
    this.recommendation.message = this.message;
    this.recommendation.patient = this.patient;
    alert(this.message +'$$$$$'+this.recommendation.caregiver.id);

    this.patientDetailsService.newRecommendation(this.recommendation)
      .subscribe( data => {
      alert('Patient created successfully');
    });
    //alert("Operation transfered to service");
  }



}

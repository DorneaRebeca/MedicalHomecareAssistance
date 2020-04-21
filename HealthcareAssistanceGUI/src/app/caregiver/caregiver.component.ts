import { Component, OnInit } from '@angular/core';
import {Caregiver} from '../model/caregiver';
import {CaregiverService} from '../services/caregiver.service';

import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {Recommendation} from '../model/recommendation';


@Component({
  selector: 'app-caregiver',
  templateUrl: './caregiver.component.html',
  styleUrls: ['./caregiver.component.css']
})
export class CaregiverComponent implements OnInit {

  loggedCaregiver: Caregiver = new Caregiver();
  client: any;
  private serverUrl = 'https://localhost:8080/socket';
  private stompClient;

  private recommendations : Recommendation[];


  ngOnInit() {
    this.caregiverService.getUserById(10).subscribe(data => {
      this.loggedCaregiver = data;
      //alert(this.loggedCaregiver.patients)
    });
  }

  constructor(
    private caregiverService: CaregiverService
  ){

    this.initializeWebSocketConnection();
    this.getRecommendations();
  }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/chat/" + 10, (message) => {
        if(message.body) {
          if(JSON.parse(message.body)["message"] !== null) {
            alert(JSON.parse(message.body)["message"]);
          }
          console.log(JSON.parse(message.body)["message"]);
        }
      });
    });
  }

  private getRecommendations() {
    this.caregiverService.getRecommendations(10).subscribe(
      rez => this.recommendations = rez
    );
  }

}

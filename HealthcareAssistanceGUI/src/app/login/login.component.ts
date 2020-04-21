import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;
  userType: number;
  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  tryLogin() {
    this.loginService.login(
      this.email,
      this.password,
      this.userType
    )
      .subscribe(
           r => {
             switch (this.userType) {
               case 1: {
                 alert("In Patient");
                 this.router.navigateByUrl('/patient').then(r => alert("Logged!! >:D< "));
                 break;
               }
               case 2: {
                 this.router.navigateByUrl('/caregiver').then(r => alert("Logged!! >:D< "));
                 break;
               }
               case 3: {
                 this.router.navigateByUrl('/doctor').then(r => alert("Logged!! >:D< "));
                 break;
               }
               default: {
                 this.router.navigateByUrl('/login').then(r => alert("Logged!! >:D< "));
                 break;
               }
             }

    }
       );
  }

}

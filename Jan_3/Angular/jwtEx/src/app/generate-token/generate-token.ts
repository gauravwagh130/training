import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { EmployService } from '../employ-service';
import { AuthRequest } from '../auth-request';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-generate-token',
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './generate-token.html',
  styleUrl: './generate-token.css',
})
export class GenerateToken {
  userName : string;
  passWord : string;
  jwt : string;
  res : Observable<string>;
  authRequest : AuthRequest;
  
  generate() {
    this.authRequest.username = this.userName;
    this.authRequest.password = this.passWord;
    // alert("Hi");
    this._employService.generateToken(this.authRequest).subscribe(x => {
      alert("Jwt " +x);
      localStorage.setItem("jwt",x);
      this.jwt = x;
      alert(this.jwt);
    })
  }
  constructor(private _employService : EmployService) {
    this.authRequest = new AuthRequest();
  }

}
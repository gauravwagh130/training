import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [RouterModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  userName : string;
  passCode : string;
  error : string;
  constructor(private _router : Router) {
  }
  login() {
    if (this.userName=="Virtusa" && this.passCode == "Virtusa") {
      this._router.navigate(["/menu"]);
    } else {
      this.error = "Invalid UserName/Password...";
    }

  }
}

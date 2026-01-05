import { Component } from '@angular/core';
import { Login } from '../login';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login-form',
  imports: [FormsModule,CommonModule],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css',
})
export class LoginForm {
  login : Login;
  isvalid : boolean;
  constructor() {
    this.login = new Login();
    this.isvalid = false;
  }

  doLogin(loginForm : NgForm) {
    if (loginForm.invalid) {
      return;
    }
    this.isvalid = true;
  }
}
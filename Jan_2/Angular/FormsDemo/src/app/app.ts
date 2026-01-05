import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployTdf } from './employ-tdf/employ-tdf';
import { LoginForm } from './login-form/login-form';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,EmployTdf,LoginForm],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('FormsDemo');
}
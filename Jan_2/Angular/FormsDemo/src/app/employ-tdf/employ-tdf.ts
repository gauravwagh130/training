import { Component } from '@angular/core';
import { Employ } from '../employ';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employ-tdf',
  imports: [FormsModule, CommonModule],
  templateUrl: './employ-tdf.html',
  styleUrl: './employ-tdf.css',
})
export class EmployTdf {
  employ: Employ;
  isValid: boolean;
  msg!: string;

  constructor() {
    this.employ = new Employ();
    this.isValid = false;
  }

  show(employForm: NgForm) {
    if (employForm.invalid) {
      return;
    }
    this.isValid = true;
    this.msg = 'Form Submitted Successfully...';
  }
}

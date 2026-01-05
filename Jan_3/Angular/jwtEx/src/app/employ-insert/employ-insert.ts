import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { EmployService } from '../employ-service';
import { Employ } from '../employ';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employ-insert',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './employ-insert.html',
  styleUrl: './employ-insert.css',
})
export class EmployInsert {
  employ: Employ;
  isValid: boolean;
  result: string;
  res: Observable<string>;
  constructor(private _employService: EmployService) {
    this.isValid = true;
    this.employ = new Employ();
  }

  addEmploy(employForm: NgForm) {
    if (employForm.invalid) {
      return;
    }
    this.isValid = true;
    // this.res = this._employService.addEmploy(this.employ);
    this._employService.addEmploy(this.employ).subscribe((x) => {
      this.result = x;
    });
  }
}

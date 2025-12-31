import { Component } from '@angular/core';
import { Employ } from '../employ';
import { EmployService } from '../employ-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employ-search',
  imports: [CommonModule, FormsModule],
  templateUrl: './employ-search.html',
  styleUrl: './employ-search.css',
})
export class EmploySearch {
  empno: number;
  employ: Observable<Employ>;

  constructor(private _employService: EmployService) {}

  search() {
    this.employ = this._employService.searchEmploy(this.empno);
  }
}

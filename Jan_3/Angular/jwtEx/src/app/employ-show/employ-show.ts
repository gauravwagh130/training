import { Component } from '@angular/core';
import { EmployService } from '../employ-service';
import { Observable } from 'rxjs';
import { Employ } from '../employ';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employ-show',
  imports: [CommonModule,FormsModule],
  templateUrl: './employ-show.html',
  styleUrl: './employ-show.css',
})
export class EmployShow {
  
   token : string;
  employs : Observable<Employ[]>;
  constructor(private _employService : EmployService) {
     this.token = localStorage.getItem("jwt");
    //  alert("Show " +this.token);
    this.employs = this._employService.showEmploy(this.token);
  }


}
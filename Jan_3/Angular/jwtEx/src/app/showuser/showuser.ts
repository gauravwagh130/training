import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { EmployService } from '../employ-service';

@Component({
  selector: 'app-showuser',
  imports: [CommonModule, FormsModule],
  templateUrl: './showuser.html',
  styleUrl: './showuser.css',
})
export class Showuser {

   token : string;
    result :string;
    res : string;
   

constructor(private _employService: EmployService) {

  this.token = localStorage.getItem("jwt");

  this._employService.showuser(this.token).subscribe({
    next: (res) => {
      this.result = res;   // 👈 ACTUAL STRING
      console.log("Result =", this.result);
    },
    error: (err) => {
      console.error(err);
    }
  });
}

    // constructor(private _employService : EmployService) {
    //    this.token = localStorage.getItem("jwt");
    //   this.result = this._employService.showuser(this.token);
    //   // this._employService.showuser(this.token).subscribe(x => {
    //   //   alert(x);
    //   //   this.res = x;
    //   // })
    // }
}
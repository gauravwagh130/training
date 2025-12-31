import { Component } from '@angular/core';
import { Employ } from '../employ';
import { EmployService } from '../employ-service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employ-show',
  standalone : true,
  imports: [CommonModule],
  templateUrl: './employ-show.html',
  styleUrl: './employ-show.css',
})
export class EmployShow {
  employs : Observable<Employ[]>

  constructor(private _employService : EmployService) {
    this.employs = this._employService.showEmploy();
  }
}

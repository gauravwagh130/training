import { Component } from '@angular/core';
import { Users } from '../users';
import { UserService } from '../user-service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
   standalone: true,
  selector: 'app-user-show',
  imports: [CommonModule],
  templateUrl: './user-show.html',
  styleUrl: './user-show.css',
})
export class UserShow {

  users : Observable<Users[]>;

  
  constructor(private _userService : UserService) {
   this.users = this._userService.showUsers();
   
  }
}

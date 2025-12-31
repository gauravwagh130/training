import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Users } from '../users';
import { UserService } from '../user-service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  standalone:true,
  selector: 'app-user-search',
  imports: [FormsModule,CommonModule],
  templateUrl: './user-search.html',
  styleUrl: './user-search.css',
})
export class UserSearch {
  id: number;
  user: Observable<Users>;

  
  constructor(private _userService : UserService) {}
  show() {
    this.user = this._userService.searchUser(this.id);
  }

}

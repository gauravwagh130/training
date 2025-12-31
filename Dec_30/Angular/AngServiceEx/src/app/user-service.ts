import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from './users';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  
  constructor(private _http : HttpClient){}

  showUsers() : Observable<Users[]> {
   return this._http.get<Users[]>("https://jsonplaceholder.typicode.com/users");
  }
  searchUser(id : number) : Observable<Users> {
    return this._http.get<Users>("https://jsonplaceholder.typicode.com/users/"+id);
  }
}

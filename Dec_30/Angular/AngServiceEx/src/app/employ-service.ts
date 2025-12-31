import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employ } from './employ';

@Injectable({
  providedIn: 'root',
})
export class EmployService {
  
  constructor(private _httpClient : HttpClient) {}

  showEmploy() : Observable<Employ[]> {
    return this._httpClient.get<Employ[]>("http://localhost:9000/showEmploy")
  }

  searchEmploy(empno : number) : Observable<Employ> {
    return this._httpClient.get<Employ>("http://localhost:9000/searchEmploy/"+empno);
  }
}

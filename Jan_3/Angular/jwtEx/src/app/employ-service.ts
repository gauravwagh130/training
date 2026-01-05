import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employ } from './employ';
import { Observable, tap } from 'rxjs';
import { AuthRequest } from './auth-request';

@Injectable({
  providedIn: 'root',
})
export class EmployService {

  constructor(private _http :HttpClient) {

  }

  showEmploy(token : string) : Observable<Employ[]> {
    var headers_object = new HttpHeaders({
      "Content-Type":"application/json",
      "Authorization":"Bearer "+token
    });
    const httpOptions = {
      headers : headers_object
    }
    // alert("Options Employ " +httpOptions)
    return this._http.get<Employ[]>("http://localhost:1111/employ/showEmploy",httpOptions);
  }



showuser(token: string): Observable<string> {

  const headers = new HttpHeaders()
    .set('Authorization', 'Bearer ' + token)
    .set('Content-Type', 'application/json');

  console.log("Authorization Header =", headers.get('Authorization'));

  return this._http.get(
    "http://localhost:1111/employ/showuser",
    {
      headers: headers,
      responseType: 'text'
    }
  );
}


   generateToken(authRequest : AuthRequest) : Observable<any> {
    return this._http.post("http://localhost:1111/employ/generateToken",authRequest,
    {responseType:'text'}).pipe(
      tap((resp) => {
        alert(resp);
      })
    )
  }


   addEmploy(employ : Employ) : Observable<string> {
     return this._http.post<string>('http://localhost:1111/employ/addEmploy', employ, {
    responseType: 'text' as 'json'  // 👈 fix: treat text as JSON-compatible
  });
  }

}
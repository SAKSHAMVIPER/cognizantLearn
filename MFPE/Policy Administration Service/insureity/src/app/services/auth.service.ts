import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { URLs } from 'app/_shared/urls';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
  }),
};
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(id: string, name: string, password: string): Observable<any> {
    return this.http.post(
      URLs.AUTH_API + 'login',
      {
        id,
        name,
        password,
      },
      httpOptions
    );
  }
  register(name: string, email: string, password: string): Observable<any> {
    return this.http.post(
      URLs.AUTH_API + 'signup',
      {
        name,
        email,
        password,
      },
      httpOptions
    );
  }
}

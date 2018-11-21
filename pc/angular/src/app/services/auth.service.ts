import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { IToken } from '../../../server/modules/auth/interfaces/token.interface';
import 'rxjs/add/operator/mergeMap';

@Injectable()
export class AuthService {
  constructor(
    private readonly httpClient: HttpClient
  ) {}

  signUp(email: string, password: string): void {
    this.httpClient.post(`api/auth/local/signup`, {
      email,
      password
    }).subscribe((token: IToken) => {
      localStorage.setItem('token', token.token);
    });
  }

  signIn(email: string, password: string): void {
    this.httpClient.post(`api/auth/local/signin`, {
      email,
      password
    }).subscribe((token: IToken) => {
      localStorage.setItem('token', token.token);
    });
  }

  requestFacebookRedirectUri(): Observable<any> {
    return this.httpClient.get('api/auth/facebook/uri');
  }

  facebookSignIn(code: string): Observable<any> {
    return this.httpClient.post('api/auth/facebook/signin', { code })
      .flatMap((token: IToken) => {
        localStorage.setItem('token', token.token);
        return of(token);
      }).pipe();
  }

  requestTwitterRedirectUri(): Observable<any> {
    return this.httpClient.get('api/auth/twitter/uri');
  }

  twitterSignIn(oauth_token: string, oauth_verifier: string): Observable<any> {
    return this.httpClient.post('api/auth/twitter/signin', { oauth_token, oauth_verifier });
  }

  requestGoogleRedirectUri(): Observable<any> {
    return this.httpClient.get('api/auth/google/uri');
  }

  googleSignIn(code: string): Observable<any> {
    return this.httpClient.post('api/auth/google/signin', { code });
  }

  getProtected(): Observable<any> {
    return this.httpClient.get(`api/auth/authorized`);
  }

  getToken(): string {
    try {
    return localStorage.getItem('token');
    } catch (e) {
      return null;
    }
  }

  isAuthenticated(): boolean {
    return !!this.getToken();
  }
}

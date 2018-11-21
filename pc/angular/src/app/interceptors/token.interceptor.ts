import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../services/auth.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  authService: AuthService;

  constructor(
    private readonly injector: Injector
  ) {}

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    this.authService = this.injector.get(AuthService);

    const bearer = `Bearer ${this.authService.getToken()}`;

    request = request.clone({
      headers: new HttpHeaders().set('Authorization', bearer)
    });

    return next.handle(request);
  }
}

import { Injectable } from '@angular/core';
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor, HttpErrorResponse
} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { TokenService } from 'src/app/shared/token.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    constructor(public readonly tokenService: TokenService) { }


    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const interceptedRequest = request.clone({
            setHeaders: {
                Authorization: this.tokenService.getToken() ? this.tokenService.getToken() : ''
            }
        });

        return next.handle(interceptedRequest).pipe(catchError(x => this.handleErrors(x)));
    }

    private handleErrors(err: HttpErrorResponse): Observable<any> {
        return of(err.message);
    }
}

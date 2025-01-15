import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserServiceService } from '../../../auth/services/storage/user-service.service';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getRooms(pageNumber: number): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.get(environment.apiBaseUrl + `/api/customer/rooms/${pageNumber}`, { headers });
  }
  
  geMyBookings(pageNumber: number): Observable<any> {
    const userId = UserServiceService.getUserId();
    const headers = this.createAuthorizationHeader();
    return this.http.get(environment.apiBaseUrl + `/api/customer/bookings/${userId}/${pageNumber}`, { headers });
  }

  createAuthorizationHeader() {
    let authHeader: HttpHeaders = new HttpHeaders();
    return authHeader.set('Authorization', 'Bearer ' + UserServiceService.getToken());
  }

  bookRoom(obj: any) {
    const headers = this.createAuthorizationHeader();
    return this.http.post(environment.apiBaseUrl + `/api/customer/book`, obj, { headers });
  }

}

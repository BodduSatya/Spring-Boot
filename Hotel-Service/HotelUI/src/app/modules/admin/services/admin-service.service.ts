import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserServiceService } from '../../../auth/services/storage/user-service.service';
import { environment } from '../../../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private http: HttpClient) { }

  postRoomDetails(roomDto: any): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.post(environment.apiBaseUrl + "/api/admin/room", roomDto, { headers });
  }

  getRooms(pageNumber: number): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.get(environment.apiBaseUrl + `/api/admin/rooms/${pageNumber}`, { headers });
  }

  getReservations(pageNumber: number): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.get(environment.apiBaseUrl + `/api/admin/reservations/${pageNumber}`, { headers });
  }

  createAuthorizationHeader() {
    let authHeader: HttpHeaders = new HttpHeaders();
    return authHeader.set(
      'Authorization', 'Bearer ' + UserServiceService.getToken()
    )
  }

  getRoomById(id: number): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.get(environment.apiBaseUrl + `/api/admin/room/${id}`, { headers });
  }

  updateRoomDetails(id: number, roomDto: any): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.put(environment.apiBaseUrl + `/api/admin/room/${id}`, roomDto, { headers });
  }

  deleteRoom(roomId: number): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.delete(environment.apiBaseUrl + `/api/admin/room/${roomId}`, { headers });
  }

  changeReservationStatus(bookingId: number, status: string): Observable<any> {
    const headers = this.createAuthorizationHeader();
    return this.http.get(environment.apiBaseUrl + `/api/admin/reservation/${bookingId}/${status}`, { headers });
  }

}

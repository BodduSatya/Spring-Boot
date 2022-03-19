import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "/api/v1";
  constructor(private httpClient: HttpClient) {

  }

  getEmployeesList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this.baseURL}` + '/employees')

  }

  saveEmployee(employee: Employee): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}` + '/createEmployee', employee)

  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseURL}` + `/employee/${id}`)
  }

  updateEmployee(id: any, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(`${this.baseURL}` + `/employee/${id}`, employee);
  }

  onDeleteEmployee(id: any, employee: Employee) {
    return this.httpClient.delete(`${this.baseURL}` + `/employee/${id}`);
  }



}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  
  employees:Employee[] | undefined;

  constructor(private employeeService: EmployeeService,
    private router : Router ) { }

  ngOnInit(): void {
      this.getEmployees();
  }

  private getEmployees(){
    return this.employeeService.getEmployeesList().subscribe(data=>{
      this.employees = data;
    });
     
  }

  updateEmployee(id: any){ 
    this.router.navigate(['updateEmployee', id]);
  }

  deleteEmployee(id: any){
    this.router.navigate(['deleteEmployee', id]);
  }

  viewEmployee(id: any){
    this.router.navigate(['viewEmployee', id]);
  }

}

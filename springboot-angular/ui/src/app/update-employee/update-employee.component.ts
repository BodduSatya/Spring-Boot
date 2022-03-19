import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id!: number;
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, 
    private route: ActivatedRoute, private router: Router ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log('*==>',this.id)
    this.employeeService.getEmployeeById(this.id).subscribe((data: Employee) => {
      this.employee = data
    },
      (error: any) => console.log(error)
    )
  }

  onUpdate() {

    this.employeeService.updateEmployee(this.id, this.employee).subscribe((data: Employee) => {
      console.log('==>',this.id)
      this.employee = data;
      this.employee = new Employee();
      this.goToEmployeeList();
    },
      (error: any) => console.log(error)
    )
  }

  goToEmployeeList(){
    this.router.navigate(['/employees'])
  }

 







}

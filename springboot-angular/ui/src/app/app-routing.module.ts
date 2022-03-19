import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { DeleteEmployeeComponent } from './delete-employee/delete-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { LoginComponent } from './login/login.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';

const routes: Routes = [
  {path:'appLogin',component:LoginComponent},
  // {path:'employees',component:EmployeeListComponent},
  // {path:'createEmployee', component:CreateEmployeeComponent},
  // {path:'updateEmployee/:id',component:UpdateEmployeeComponent},
  // {path:'deleteEmployee/:id',component:DeleteEmployeeComponent},
  // {path:'viewEmployee/:id',component:ViewEmployeeComponent},
  // {path:'',redirectTo:'employees',pathMatch:'full'}
  {path:'',redirectTo:'appLogin',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

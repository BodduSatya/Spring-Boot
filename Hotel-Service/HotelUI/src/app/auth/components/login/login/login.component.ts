import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { NzFormControlComponent, NzFormItemComponent } from 'ng-zorro-antd/form';
import { NzInputGroupComponent } from 'ng-zorro-antd/input';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AuthService } from '../../../services/auth/auth.service';
import { UserServiceService } from '../../../services/storage/user-service.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [NzFormItemComponent,
    NzFormControlComponent,
    NzInputGroupComponent,
    ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginForm!: FormGroup;

  constructor(private fb: FormBuilder, private authservice: AuthService,
    private message: NzMessageService, private router: Router
  ) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],   // Fix validators syntax
      password: [null, [Validators.required]]                  // Fix validators syntax
    });
  }

  submitForm() {
    console.log(this.loginForm);
    console.log(this.loginForm.value);

    this.authservice.login(this.loginForm.value).subscribe(res => {
      if (res.userId != null) {
        const user = {
          id: res.userId,
          role: res.userRole
        }
        console.log(res);

        UserServiceService.saveUser(user);
        UserServiceService.saveToken(res.token);

        //this.message.success("Login Successful",{nzDuration:5000});
        // this.router.navigateByUrl("/");

        if (UserServiceService.isAdminLoggedin()) {
          this.router.navigateByUrl('admin/dashboard')
        }
        else if (UserServiceService.isCustomerLoggedIn()) {
          this.router.navigateByUrl('customer/rooms')
        }
      }

    }, error => {
      this.message.error('Bad credentials', { nzDuration: 5000 })
    }
    );
  }
}

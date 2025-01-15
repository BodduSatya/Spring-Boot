import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { NzFormControlComponent, NzFormItemComponent } from 'ng-zorro-antd/form';
import { NzInputGroupComponent } from 'ng-zorro-antd/input';
import { AuthService } from '../../services/auth/auth.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    NzFormItemComponent, NzFormControlComponent, NzInputGroupComponent, ReactiveFormsModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {

  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService,
    private message: NzMessageService,
    private router: Router
  ) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],   // Fix validators syntax
      password: [null, [Validators.required]],                  // Fix validators syntax
      name: [null, [Validators.required]]                        // Fix validators syntax
    });
  }

  submitForm(){
    this.authService.register(this.registerForm.value).subscribe(res=>{
      if( res.id !=null){
        this.message.success("Signup Successful",{nzDuration:5000});
        this.router.navigateByUrl("/");
      }
      else{
        this.message.error(`${res.message}`,{nzDuration:5000})
      }
    });
  }

}

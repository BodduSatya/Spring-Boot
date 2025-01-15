import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';

import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { NzFormControlComponent, NzFormItemComponent, NzFormLabelComponent } from 'ng-zorro-antd/form';
import { NzFormModule } from 'ng-zorro-antd/form';  // Import NzFormModule
import { AdminServiceService } from '../../services/admin-service.service';

@Component({
  selector: 'app-post-room',
  standalone: true,
  imports: [NzFormItemComponent,
    NzFormControlComponent,
    NzFormLabelComponent,
    NzFormModule,
    ReactiveFormsModule],
  templateUrl: './post-room.component.html',
  styleUrl: './post-room.component.scss'
})
export class PostRoomComponent {

  roomDetailsForm: FormGroup;
  constructor(private fb: FormBuilder,
    private message: NzMessageService,
    private router: Router,
    private adminService: AdminServiceService
  ) {
    this.roomDetailsForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      price: ['', Validators.required]
    })
  }

  submitForm() {
    this.adminService.postRoomDetails(this.roomDetailsForm.value).subscribe(res => {
      this.message.success(`Room Posted Successfully.`, { nzDuration: 5000 })
      this.router.navigateByUrl('/admin/dashboard')
    }, error => {
      this.message.error(`${error.error}`, { nzDuration: 5000 })
    })
  }

}

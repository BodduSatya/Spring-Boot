import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AdminServiceService } from '../../services/admin-service.service';
import { NzFormControlComponent, NzFormItemComponent, NzFormLabelComponent } from 'ng-zorro-antd/form';
import { NzFormModule } from 'ng-zorro-antd/form';

@Component({
  selector: 'app-update-room',
  standalone: true,
  imports: [NzFormItemComponent, NzFormControlComponent, NzFormLabelComponent,
    NzFormModule, ReactiveFormsModule],
  templateUrl: './update-room.component.html',
  styleUrl: './update-room.component.scss'
})
export class UpdateRoomComponent {

  id: number;
  updateRoomForm: FormGroup;
  constructor(private fb: FormBuilder, private message: NzMessageService,
    private router: Router, private adminService: AdminServiceService,
    private activatedRoute: ActivatedRoute) {

    this.updateRoomForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      price: ['', Validators.required]
    });

    this.id = this.activatedRoute.snapshot.params['id'];
    this.getRoomById();

  }

  submitForm() {
    this.adminService.updateRoomDetails(this.id, this.updateRoomForm.value).subscribe(res => {
      this.message.success(`Room Updated Successfully.`, { nzDuration: 5000 })
      this.router.navigateByUrl('/admin/dashboard')
    }, error => {
      this.message.error(`${error.error}`, { nzDuration: 5000 })
    })
  }

  getRoomById() {
    this.adminService.getRoomById(this.id).subscribe(res => {
      this.updateRoomForm.patchValue(res);
    }, error => {
      this.message.error(`${error.error}`, { nzDuration: 5000 });
    })
  }

}

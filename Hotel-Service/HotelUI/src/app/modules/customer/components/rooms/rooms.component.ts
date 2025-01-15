import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzSkeletonModule } from 'ng-zorro-antd/skeleton';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { NzPaginationModule } from 'ng-zorro-antd/pagination';
import { UserServiceService } from '../../../../auth/services/storage/user-service.service';
import { FormsModule } from '@angular/forms';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzDatePickerComponent } from 'ng-zorro-antd/date-picker';
import { NzModalComponent, NzModalModule } from 'ng-zorro-antd/modal';

@Component({
  selector: 'app-rooms',
  standalone: true,
  imports: [NzButtonModule, NzCardModule, NzAvatarModule, NzSkeletonModule,
    NzIconModule, CommonModule, RouterModule,
    NzPaginationModule, FormsModule, NzModalComponent,
    NzFormModule, CommonModule, NzDatePickerComponent, NzModalModule
  ],
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.scss'
})
export class RoomsComponent {

  currentPage = 1;
  rooms = [];
  total: any;
  loading: boolean = false;
  price: number;

  constructor(private customerService: CustomerService,
    private message: NzMessageService
  ) {
    this.getRooms();
  }

  getRooms() {
    this.customerService.getRooms(this.currentPage - 1).subscribe(res => {
      console.log(res);
      this.rooms = res.roomDtoList;
      this.total = res.totalPages * 1;
    })
  }

  pageIndexChange(value: any) {
    this.currentPage = value;
    this.getRooms();
  }

  isVisibleMiddle = false;
  date: Date[] = [];
  checkInDate: Date;
  checkOutDate: Date;
  id: number;

  onChange(result: Date[]) {
    if (result.length === 2) {
      this.checkInDate = result[0];
      this.checkOutDate = result[1];
    }
  }

  handleCancelMiddle() {
    this.isVisibleMiddle = false;
  }

  handleOkMiddle(): void {
    const obj = {
      userId: UserServiceService.getUserId(),
      roomId: this.id,
      checkInDate: this.date[0],
      checkOutDate: this.date[1],
      price: this.price
    }

    this.customerService.bookRoom(obj).subscribe(res => {
      this.message.success(`Request submitted for approval.`, { nzDuration: 5000 })
      this.isVisibleMiddle = false;
    }, error => {
      this.message.error(`${error.error}`, { nzDuration: 5000 })
    })
  }

  showModalMiddle(id: number, price: number) {
    this.id = id;
    this.isVisibleMiddle = true;
    this.price = price;
  }



}

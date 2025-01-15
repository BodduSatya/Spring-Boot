import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzTableComponent } from 'ng-zorro-antd/table';
import { NzPaginationComponent } from 'ng-zorro-antd/pagination';
import { CommonModule } from '@angular/common';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzTagModule } from 'ng-zorro-antd/tag';

@Component({
  selector: 'app-view-bookings',
  standalone: true,
  imports: [NzTableComponent,NzPaginationComponent,CommonModule,NzIconModule, NzTagModule],
  templateUrl: './view-bookings.component.html',
  styleUrl: './view-bookings.component.scss'
})
export class ViewBookingsComponent {

  currentPage: any = 1;
  total:any;
  bookings:any;

  constructor(private customerservice: CustomerService,
    private message: NzMessageService
  ) {
    this.getBookings();
  }

  getBookings() {
    this.customerservice.geMyBookings(this.currentPage-1).subscribe(res => {
      console.log(res);
      this.bookings = res.reservationDtoList;
      this.total = res.totalPages*5;
    }, error => {
      this.message.error(`${error.error}`, { nzDuration: 5000 })
    })
  }

  pageIndexChange(value:any){
    this.currentPage = value;
    this.getBookings();
  }
}

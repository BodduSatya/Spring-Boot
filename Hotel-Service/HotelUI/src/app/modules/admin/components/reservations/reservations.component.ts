import { Component } from '@angular/core';
import { AdminServiceService } from '../../services/admin-service.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzTableComponent } from 'ng-zorro-antd/table';
import { NzPaginationComponent } from 'ng-zorro-antd/pagination';
import { CommonModule } from '@angular/common';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzTagModule } from 'ng-zorro-antd/tag';

@Component({
  selector: 'app-reservations',
  standalone: true,
  imports: [NzTableComponent,NzPaginationComponent,CommonModule,NzIconModule, NzTagModule],
  templateUrl: './reservations.component.html',
  styleUrl: './reservations.component.scss'
})
export class ReservationsComponent {

   currentPage: any = 1;
   total:any;
   reservations:any;

   constructor( private adminService: AdminServiceService,
    private message : NzMessageService
   ){
      this.getReservations();
   }

   getReservations(){
    this.adminService.getReservations(this.currentPage-1).subscribe(res=>{
      console.log(res);
      this.reservations = res.reservationDtoList;
      this.total = res.totalPages * 5;
    })
   }

   pageIndexChange(value:any){
     this.currentPage = value;
     this.getReservations();
   }

   changeReservationStatus(bookingId:number, status:string){
    this.adminService.changeReservationStatus(bookingId,status).subscribe(res => {
      this.message.success(`Reservation status updated Successfully.`, { nzDuration: 5000 })
      // this.router.navigateByUrl('/admin/dashboard')
      this.getReservations();
    }, error => {
      this.message.error(`${error.error}`, { nzDuration: 5000 })
    })

   }
}

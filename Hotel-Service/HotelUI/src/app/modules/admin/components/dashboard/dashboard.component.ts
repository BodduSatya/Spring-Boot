import { Component } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AdminServiceService } from '../../services/admin-service.service';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzSkeletonModule } from 'ng-zorro-antd/skeleton';
import { NzIconModule } from 'ng-zorro-antd/icon';
// import { NzTemplateModule } from 'ng-zorro-antd/core/template';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { NzPaginationModule } from 'ng-zorro-antd/pagination';
import { NzModalService } from 'ng-zorro-antd/modal';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NzButtonModule, NzCardModule, NzAvatarModule, NzSkeletonModule,
    NzIconModule, CommonModule, RouterModule,
    NzPaginationModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  currentPage = 1;
  rooms = [];
  total: any;
  loading: boolean = false;

  constructor(private adminService: AdminServiceService,
    private message: NzMessageService,
    private modalService: NzModalService
  ) {
    this.getRooms();
  }

  getRooms() {
    this.adminService.getRooms(this.currentPage - 1).subscribe(res => {
      console.log(res);
      this.rooms = res.roomDtoList;
      this.total = res.totalPages * 1;
    })
  }

  pageIndexChange(value: any) {
    this.currentPage = value;
    this.getRooms();
  }

  showConfirm(roomId: number) {
    this.modalService.confirm({
      nzTitle: 'Confirm',
      nzContent: 'Do you want to delete this room?',
      nzOkText: 'Delete',
      nzCancelText: 'Cancel',
      nzOnOk: () => this.deleteRoom(roomId)
    })
  }

  deleteRoom(id: number) {
    this.adminService.deleteRoom(id).subscribe(res => {
      this.message.success(`Room Deleted Successfully.`, { nzDuration: 5000 });
      this.getRooms();
    },
      error => {
        this.message.error(`${error.error}`, { nzDuration: 5000 })
      }
    )
  }
}

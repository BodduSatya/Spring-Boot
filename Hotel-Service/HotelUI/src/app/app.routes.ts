import { Routes } from '@angular/router';
import { RegisterComponent } from './auth/components/register/register.component';
import { LoginComponent } from './auth/components/login/login/login.component';
import { RoomsComponent } from './modules/customer/components/rooms/rooms.component';
import { DashboardComponent } from './modules/admin/components/dashboard/dashboard.component';
import { PostRoomComponent } from './modules/admin/components/post-room/post-room.component';
import { UpdateRoomComponent } from './modules/admin/components/update-room/update-room.component';
import { ReservationsComponent } from './modules/admin/components/reservations/reservations.component';
import { ViewBookingsComponent } from './modules/customer/components/view-bookings/view-bookings.component';

export const routes: Routes = [
    { path: 'register', component: RegisterComponent },
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },

    { path: 'admin/dashboard', component: DashboardComponent },
    { path: 'admin/room', component: PostRoomComponent },
    { path: 'admin/room/:id/edit', component: UpdateRoomComponent },
    { path: 'admin/reservations', component: ReservationsComponent },

    { path: 'customer/rooms', component: RoomsComponent },
    { path: 'customer/bookings', component: ViewBookingsComponent },

];

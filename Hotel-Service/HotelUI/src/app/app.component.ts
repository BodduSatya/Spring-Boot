import { Component } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { DemoNgZorroAntdModule } from './DemoNgZorroAntdModule';
import { ReactiveFormsModule } from '@angular/forms';
import { UserServiceService } from './auth/services/storage/user-service.service';
import { CommonModule } from '@angular/common';  // Import the CommonModule

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule, DemoNgZorroAntdModule, ReactiveFormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'HotelUI';

  isCustomerLoggedIn: boolean = UserServiceService.isCustomerLoggedIn();
  isAdminLoggedIn: boolean = UserServiceService.isAdminLoggedin();

  constructor(private router: Router) { }

  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event.constructor.name == 'NavigationEnd') {
        this.isCustomerLoggedIn = UserServiceService.isCustomerLoggedIn();
        this.isAdminLoggedIn = UserServiceService.isAdminLoggedin();

        console.log('isAdminLoggedIn=', this.isAdminLoggedIn);
        console.log('isCustomerLoggedIn=', this.isCustomerLoggedIn);

      }
    })
  }

  logout() {
    UserServiceService.signOut();
    this.router.navigateByUrl('/');
  }

}

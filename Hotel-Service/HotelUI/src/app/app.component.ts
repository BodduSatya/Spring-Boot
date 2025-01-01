import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DemoNgZorroAntdModule } from './DemoNgZorroAntdModule';
// import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,DemoNgZorroAntdModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'HotelUI';
}

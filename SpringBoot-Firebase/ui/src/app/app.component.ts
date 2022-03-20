import { Component, OnInit } from '@angular/core';
import { environment } from "../environments/environment";
import { getMessaging, getToken, onMessage } from "firebase/messaging";
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'af-notification';
  message: any = null;
  constructor(private notifyService: NotificationService) { }

  ngOnInit(): void {
    this.requestPermission();
    this.listen();
  }
  requestPermission() {
    const messaging = getMessaging();
    getToken(messaging,
      { vapidKey: environment.firebase.vapidKey }).then(
        (currentToken) => {
          if (currentToken) {
            console.log("we got the token.....");
            console.log(currentToken);
          } else {
            console.log('No registration token available. Request permission to generate one.');
          }
        }).catch((err) => {
          console.log('An error occurred while retrieving token. ', err);
        });
  }
  listen() {
    const messaging = getMessaging();
    onMessage(messaging, (payload) => {
      console.log('Message received.*** ', payload);
      this.message = payload;
  
 
       this.showToasterSuccess(this.message.notification.body,this.message.notification.title);
       this.showToasterError(this.message.notification.body,this.message.notification.title)
       this.showToasterInfo(this.message.notification.body,this.message.notification.title)
       this.showToasterWarning(this.message.notification.body,this.message.notification.title)

    });
  }

  showToasterSuccess(_msg: any, _title: any) {
     
    this.notifyService.showSuccess(_msg,_title);
  }

  showToasterError(_msg: any, _title: any) {
    this.notifyService.showError(_msg,_title);
  }

  showToasterInfo(_msg: any, _title: any) {
    this.notifyService.showInfo(_msg,_title);
  }

  showToasterWarning(_msg: any, _title: any) {
    this.notifyService.showWarning(_msg,_title);
  }



}
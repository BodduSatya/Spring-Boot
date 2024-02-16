# Spring Boot | Exploring Asynchronous Calls with @Async Annotation


* POST http://localhost:8080/orders

* Request BODY
  {
      "productId": 1,
      "name": "Mac Book Pro",
      "productType": "Mac Book",
      "qty": 1,
      "price": 98999
  }

* Response 

  {
      "productId": 1,
      "name": "Mac Book Pro",
      "productType": "Mac Book",
      "qty": 1,
      "price": 98999.0,
      "trackingId": "2ffc9cd8-5c95-4452-bd57-b8fb99a37c64"
  }


 ```
  =>Request
  07:47:06.289+05:30  INFO 4320 --- [nio-8080-exec-2] o.s.p.service.PaymentService             : Initiate payment for order 1
  07:47:08.293+05:30  INFO 4320 --- [nio-8080-exec-2] o.s.p.service.PaymentService             : completed payment for order 1
  =>Got the response 

  Asynchronously executing following tasks
  07:47:10.302+05:30  INFO 4320 --- [yncTaskThread-3] o.s.p.service.OrderService               : Order packaging completed AsyncTaskThread-3
  07:47:12.305+05:30  INFO 4320 --- [yncTaskThread-1] o.s.p.service.OrderService               : Notified to the user AsyncTaskThread-1
  07:47:13.317+05:30  INFO 4320 --- [yncTaskThread-3] o.s.p.service.OrderService               : Trailer assigned and Order dispatched AsyncTaskThread-3
  07:47:13.317+05:30  INFO 4320 --- [yncTaskThread-2] o.s.p.service.OrderService               : Assign order to vendor AsyncTaskThread-2
  07:47:18.310+05:30  INFO 4320 --- [yncTaskThread-4] o.s.p.service.OrderService               : Delivery partner assigned AsyncTaskThread-4
```

![image](https://github.com/BodduSatya/Spring-Boot/assets/24984593/866a0d26-9d91-46fa-a580-b1b9f6657f44)

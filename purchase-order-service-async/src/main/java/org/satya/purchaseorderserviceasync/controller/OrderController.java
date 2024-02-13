package org.satya.purchaseorderserviceasync.controller;

import org.satya.purchaseorderserviceasync.dto.Order;
import org.satya.purchaseorderserviceasync.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
        orderService.processOrder(order); //synchronous

        //asynchronous
        orderService.notifyUser(order);
        orderService.assignVendor(order);
        orderService.packaging(order);
        orderService.assignDeliveryPartner(order);
        orderService.assignTrailerAndDispatch(order);
        return ResponseEntity.ok(order);
    }


}

package org.satya.purchaseorderserviceasync.service;

import lombok.extern.slf4j.Slf4j;
import org.satya.purchaseorderserviceasync.dto.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public void processPayment(Order order) throws InterruptedException {
        log.info("Initiate payment for order {}",order.getProductId());

        //call actual payment gateway

        Thread.sleep(2000L);
        log.info("completed payment for order {} ",order.getProductId());
    }
}

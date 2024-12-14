package com.springproject.droolEngineProject.service;

import com.springproject.droolEngineProject.model.Order;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final KieContainer kieContainer;

    public OrderService(KieContainer kieContainer ){
        this.kieContainer = kieContainer;
    }

    public Order getDiscountForOrder(Order order) {
        KieSession session = kieContainer.newKieSession();
        session.insert(order);
        session.fireAllRules();
        session.dispose();
        return order;
    }
}

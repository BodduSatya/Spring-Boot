package com.satya.HotelServer.controller.customer;

import com.satya.HotelServer.service.customer.room.CustomerRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerRoomController {

    private final CustomerRoomService customerRoomService;

}

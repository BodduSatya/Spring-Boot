package com.satya.HotelServer.service.customer.room;

import com.satya.HotelServer.dto.RoomsResponseDto;

public interface CustomerRoomService {

    RoomsResponseDto getAvailableRooms(int pageNumber);

}
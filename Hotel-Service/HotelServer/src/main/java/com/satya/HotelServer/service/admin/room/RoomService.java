package com.satya.HotelServer.service.admin.room;

import com.satya.HotelServer.dto.RoomDto;
import com.satya.HotelServer.dto.RoomsResponseDto;

public interface RoomService {

    boolean postRoom(RoomDto roomDto);

    RoomsResponseDto getAllRooms(int pageNumber);

    RoomDto getRoomById(Long roomId);

    boolean updateRoom(Long id, RoomDto roomDto);

    void deleteRoom(Long roomId);
}

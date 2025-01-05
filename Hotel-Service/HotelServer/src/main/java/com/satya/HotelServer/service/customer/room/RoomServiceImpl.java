package com.satya.HotelServer.service.customer.room;

import com.satya.HotelServer.dto.RoomsResponseDto;
import com.satya.HotelServer.entity.Room;
import com.satya.HotelServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("customerRoomServiceImpl")
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomsResponseDto getAvailableRooms(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Room> roomPage = roomRepository.findByAvailable(true,pageable);
        RoomsResponseDto roomsResponseDto = new RoomsResponseDto();
        roomsResponseDto.setPageNumber(roomPage.getNumber());
        roomsResponseDto.setTotalPages(roomPage.getTotalPages());
        roomsResponseDto.setRoomDtoList(roomPage.stream().map(Room::getRoomDto).collect(Collectors.toList()));
        return roomsResponseDto;
    }

}

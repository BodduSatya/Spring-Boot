package com.satya.HotelServer.service.admin.room;

import com.satya.HotelServer.dto.RoomDto;
import com.satya.HotelServer.dto.RoomsResponseDto;
import com.satya.HotelServer.entity.Room;
import com.satya.HotelServer.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service("adminRoomServiceImpl")
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private  final RoomRepository roomRepository;

    public boolean postRoom(RoomDto roomDto) {
        try{
            Room room = new Room();
            room.setName(roomDto.getName());
            room.setPrice(roomDto.getPrice());
            room.setType(roomDto.getType());
            room.setAvailable(true);
            roomRepository.save(room);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public RoomsResponseDto getAllRooms(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Room> roomPage = roomRepository.findAll(pageable);
        RoomsResponseDto roomsResponseDto = new RoomsResponseDto();
        roomsResponseDto.setPageNumber(roomPage.getNumber());
        roomsResponseDto.setTotalPages(roomPage.getTotalPages());
        roomsResponseDto.setRoomDtoList(roomPage.stream().map(Room::getRoomDto).collect(Collectors.toList()));
        return roomsResponseDto;
    }

    public RoomDto getRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.isPresent()){
            return room.get().getRoomDto();
        }else {
            throw new EntityNotFoundException("Room not present");
        }
    }

    public boolean updateRoom(Long id, RoomDto roomDto) {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()){
            Room existingRoom = room.get();
            existingRoom.setName(roomDto.getName());
            existingRoom.setPrice(roomDto.getPrice());
            existingRoom.setType(roomDto.getType());
            roomRepository.save(existingRoom);
            return true;
        }
        return false;
    }

    public void deleteRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.isPresent()){
            roomRepository.delete(room.get());
        }else{
            throw new EntityNotFoundException("Room not present");
        }
    }
}

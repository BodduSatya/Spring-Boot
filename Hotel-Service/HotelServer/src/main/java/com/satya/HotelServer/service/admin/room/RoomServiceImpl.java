package com.satya.HotelServer.service.admin.room;

import com.satya.HotelServer.dto.RoomDto;
import com.satya.HotelServer.entity.Room;
import com.satya.HotelServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
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
}

package com.satya.HotelServer.entity;

import com.satya.HotelServer.dto.RoomDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Long price;
    private boolean available;

    public RoomDto getRoomDto() {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(id);
        roomDto.setName(name);
        roomDto.setType(type);
        roomDto.setPrice(price);
        roomDto.setAvailable(available);
        return roomDto;
    }
}

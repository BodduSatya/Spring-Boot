package com.satya.HotelServer.controller.admin;

import com.satya.HotelServer.dto.RoomDto;
import com.satya.HotelServer.entity.Room;
import com.satya.HotelServer.service.admin.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<?> postRoom(@RequestBody RoomDto roomDto) {
        boolean success = roomService.postRoom(roomDto);
        return success ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}

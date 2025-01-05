package com.satya.HotelServer.controller.admin;

import com.satya.HotelServer.dto.RoomDto;
import com.satya.HotelServer.service.admin.room.AdminRoomService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("adminController")
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminRoomController {

    private final AdminRoomService adminRoomService;

    @PostMapping("/room")
    public ResponseEntity<?> postRoom(@RequestBody RoomDto roomDto) {
        boolean success = adminRoomService.postRoom(roomDto);
        return success ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/rooms/{pageNumber}")
    public ResponseEntity<?> getAllRooms(@PathVariable int pageNumber) {
        return ResponseEntity.ok(adminRoomService.getAllRooms(pageNumber));
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(adminRoomService.getRoomById(id));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/room/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
         boolean success = adminRoomService.updateRoom(id,roomDto);

         return success ?
                 ResponseEntity.status(HttpStatus.OK).build() :
                 ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable Long id) {
        try{
            adminRoomService.deleteRoom(id);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

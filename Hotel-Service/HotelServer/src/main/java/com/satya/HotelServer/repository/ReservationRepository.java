package com.satya.HotelServer.repository;

import com.satya.HotelServer.dto.ReservationResponseDto;
import com.satya.HotelServer.entity.Reservation;
import com.satya.HotelServer.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findAllByUserId(Pageable pageable, Long userId);

    Long user(User user);
}

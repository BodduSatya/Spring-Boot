package com.satya.HotelServer.service.customer.booking;

import com.satya.HotelServer.dto.ReservationDto;
import com.satya.HotelServer.dto.ReservationResponseDto;

public interface BookingService {
    boolean postReservation(ReservationDto reservationDto);
    ReservationResponseDto getAllReservationByUserId(Long userId, int pageNumber);
}

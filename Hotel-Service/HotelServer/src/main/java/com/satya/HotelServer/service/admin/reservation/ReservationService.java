package com.satya.HotelServer.service.admin.reservation;

import com.satya.HotelServer.dto.ReservationResponseDto;

public interface ReservationService {
    ReservationResponseDto getAllReservations(int pageNo);
    boolean changeReservationStatus( Long id, String status);
}

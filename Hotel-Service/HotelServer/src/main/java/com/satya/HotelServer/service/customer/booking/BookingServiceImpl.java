package com.satya.HotelServer.service.customer.booking;

import com.satya.HotelServer.dto.ReservationDto;
import com.satya.HotelServer.dto.ReservationResponseDto;
import com.satya.HotelServer.entity.Reservation;
import com.satya.HotelServer.entity.Room;
import com.satya.HotelServer.entity.User;
import com.satya.HotelServer.enums.ReservationStatus;
import com.satya.HotelServer.repository.ReservationRepository;
import com.satya.HotelServer.repository.RoomRepository;
import com.satya.HotelServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.satya.HotelServer.service.admin.reservation.ReservationServiceImpl.SEARCH_RESULT_PER_PAGE;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;


    public boolean postReservation(ReservationDto reservationDto) {
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());
        Optional<Room> optionalRoom = roomRepository.findById(reservationDto.getRoomId());

        if(optionalUser.isPresent() && optionalRoom.isPresent()) {
            Reservation reservation = new Reservation();
            reservation.setUser(optionalUser.get());
            reservation.setRoom(optionalRoom.get());
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);

            Long days = ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            reservation.setPrice(days * reservationDto.getPrice());
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }

    public ReservationResponseDto getAllReservationByUserId(Long userId,int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, SEARCH_RESULT_PER_PAGE);
        Page<Reservation> reservationPage = reservationRepository.findAllByUserId(pageable, userId);
        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
        reservationResponseDto.setReservationDtoList(reservationPage.stream().map(Reservation::getReservationDto).collect(Collectors.toList()));

        reservationResponseDto.setPageNumber(reservationPage.getPageable().getPageNumber());
        reservationResponseDto.setTotalPages(reservationPage.getTotalPages());
        return reservationResponseDto;
    }

}

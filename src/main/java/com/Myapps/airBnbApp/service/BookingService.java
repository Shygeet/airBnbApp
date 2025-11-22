package com.Myapps.airBnbApp.service;

import java.util.List;

import com.Myapps.airBnbApp.dto.BookingDto;
import com.Myapps.airBnbApp.dto.BookingRequestDto;
import com.Myapps.airBnbApp.dto.GuestDto;

public interface BookingService {

	BookingDto initializeBooking(BookingRequestDto bookingRequestDto);

	BookingDto addGuests(Long bookingId, List<GuestDto> guests);

}

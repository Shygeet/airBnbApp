package com.Myapps.airBnbApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myapps.airBnbApp.dto.BookingDto;
import com.Myapps.airBnbApp.dto.BookingRequestDto;
import com.Myapps.airBnbApp.dto.GuestDto;
import com.Myapps.airBnbApp.service.BookingService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
class HotelBookingController 
{
	
	private final BookingService bookingService;
	
	@PostMapping("/init")
	public ResponseEntity<BookingDto> initializeBooking(@RequestBody BookingRequestDto bookingRequestDto)
	{
		return ResponseEntity.ok(bookingService.initializeBooking(bookingRequestDto));
	}
	
	@PostMapping("/{bookingId}/addGuests")
	public ResponseEntity<BookingDto> addGuests(@PathVariable Long bookingId , @RequestBody List<GuestDto> guests)
	{
		return ResponseEntity.ok(bookingService.addGuests(bookingId,guests));
	}

}

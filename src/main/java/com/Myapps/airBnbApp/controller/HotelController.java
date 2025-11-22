package com.Myapps.airBnbApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.entity.Hotel;
import com.Myapps.airBnbApp.service.HotelService;

import exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins="http://localhost:3000")
public class HotelController {
	
	
	private final HotelService hotelService;
	
	 
	@PostMapping("/hotels")
	public HotelDto createHotel(@RequestBody HotelDto hotelDto)
	{
		
		HotelDto hotel=hotelService.createHotel(hotelDto);
		//return new ResponseEntity<>(hotel,HttpStatus.CREATED);
		return hotel;
	
	}
	
	@GetMapping("/hotels/{hotelId}")
	public HotelDto getHotelById(@PathVariable Long hotelId)
	{
		HotelDto hotel=hotelService.getHotelById(hotelId); 
		return hotel;
	}
	
	@PutMapping("/hotels/{hotelId}")
	public HotelDto updateHotelById(@PathVariable Long hotelId,@RequestBody HotelDto hotelDto)
	{
		HotelDto hotel=hotelService.updateHotelById(hotelId, hotelDto);
		return hotel;
	}
	
	@DeleteMapping("/hotels/{hotelId}")
	public String deleteHotelById(@PathVariable Long hotelId)
	{
		hotelService.deleteHotelById(hotelId);
		return "Hotel deleted";
	}
	
	@PatchMapping("/hotels/{hotelId}")
	public ResponseEntity<Void> activateHotelById(@PathVariable Long hotelId)
	{
		hotelService.activateHotel(hotelId);
		return ResponseEntity.noContent().build();
	}
	
	
}

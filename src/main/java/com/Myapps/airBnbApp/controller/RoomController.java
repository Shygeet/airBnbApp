package com.Myapps.airBnbApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.dto.RoomDto;
import com.Myapps.airBnbApp.service.RoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class RoomController {
	
	@Autowired
	private final RoomService roomService;
	
	@PostMapping("/createRooms/{hotelId}")
	public List<RoomDto> createRoom(@PathVariable Long hotelId,@RequestBody List<RoomDto> roomDto)
	{
		
		List<RoomDto> room=roomService.createNewRoom(hotelId,roomDto);
		//return new ResponseEntity<>(hotel,HttpStatus.CREATED);
		return room;
	
	}
	
	@GetMapping("/fetchRoom/{roomId}")
	public RoomDto getRoomById(@PathVariable Long roomId)
	{
		RoomDto room=roomService.getRoomById(roomId); 
		return room;
	}
	
	@GetMapping("/fetchAllRooms/{hotelId}")
	public List<RoomDto> getAllRoomOfHotel(@PathVariable Long hotelId)
	{
		List<RoomDto> rooms=roomService.getAllRoomsOfHotel(hotelId); 
		return rooms;
	}
	
	
	@DeleteMapping("/deleteRoom/{roomId}")
	public String deleteRoomById(@PathVariable Long roomId)
	{
		roomService.deleteRoomById(roomId);
		return "Room deleted";
	}
	
	

}

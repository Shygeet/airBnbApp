package com.Myapps.airBnbApp.service;

import java.util.List;

import com.Myapps.airBnbApp.dto.RoomDto;

public interface RoomService {
	
	List<RoomDto> createNewRoom(Long hotelId , List<RoomDto> roomDto);
	
	List<RoomDto> getAllRoomsOfHotel(Long hotelId);
	
	
	RoomDto getRoomById(Long roomId);
	void deleteRoomById(Long roomId);
}

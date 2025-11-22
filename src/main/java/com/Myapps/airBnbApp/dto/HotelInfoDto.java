package com.Myapps.airBnbApp.dto;

import java.util.List;

import com.Myapps.airBnbApp.entity.Room;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelInfoDto {
	
	private HotelDto hotelDto;
	private List<RoomDto> roomDtos;

}

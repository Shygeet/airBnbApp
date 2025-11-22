package com.Myapps.airBnbApp.service;

import org.springframework.data.domain.Page;

import com.Myapps.airBnbApp.dto.BrowseHotelDto;
import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.entity.Room;

public interface InventoryService {

	
	public void initializeRoomForAYear(Room room);
	
	public void deleteInventoryByRoomId(Long id);

	public Page<HotelDto> browseHotels(BrowseHotelDto browseHotelDto);
}

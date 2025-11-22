package com.Myapps.airBnbApp.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myapps.airBnbApp.dto.BrowseHotelDto;
import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.dto.HotelInfoDto;
import com.Myapps.airBnbApp.service.HotelService;
import com.Myapps.airBnbApp.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/browseHotels")
@RequiredArgsConstructor
public class BrowseHotelController {
	
	private final InventoryService inventoryService;
	private final HotelService hotelService;
	
	@GetMapping("/search")
	public ResponseEntity<Page<HotelDto>> 
	browseHotels(@RequestBody BrowseHotelDto browseHotelDto)
	{
		
	 Page<HotelDto> page = inventoryService.browseHotels(browseHotelDto);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{hotelId}/info")
	public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId)
	{
		return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
	}
	

}

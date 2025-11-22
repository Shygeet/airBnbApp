package com.Myapps.airBnbApp.service;

import java.util.List;


import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.dto.HotelInfoDto;
import com.Myapps.airBnbApp.entity.Hotel;




public interface HotelService {
	
	HotelDto createHotel(HotelDto hotelDto);
	
	HotelDto getHotelById(Long id);
	
	List<Hotel> getHotelByName(Long id);
	
	List<Hotel> getAllHotels();
	
	HotelDto updateHotelById(Long id, HotelDto hotelDto);
	
	void deleteHotelById(Long id);
	
	void activateHotel(Long id);

	HotelInfoDto getHotelInfoById(Long hotelId);

	

	
	
	

}

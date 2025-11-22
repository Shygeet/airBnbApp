package com.Myapps.airBnbApp.service;

import java.util.List;

import javax.lang.model.element.Element;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.dto.HotelInfoDto;
import com.Myapps.airBnbApp.dto.RoomDto;
import com.Myapps.airBnbApp.entity.Hotel;
import com.Myapps.airBnbApp.entity.Room;
import com.Myapps.airBnbApp.repository.HotelRepository;

import exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;





@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
	
@Autowired
private  HotelRepository hotelRepository;
@Autowired
private InventoryService inventoryService;
@Autowired
private RoomService roomService;

private  ModelMapper modelMapper=new ModelMapper();


    
	@Override
	public HotelDto createHotel(HotelDto hotelDto) {
		// TODO Auto-generated method stub
	Hotel hotel=modelMapper.map(hotelDto, Hotel.class);
	hotel= hotelRepository.save(hotel);
	hotelDto=modelMapper.map(hotel, HotelDto.class);
	return hotelDto;
	}

	@Override
	public HotelDto getHotelById(Long id) {
		// TODO Auto-generated method stub
		Hotel Hotel= hotelRepository.findById(id)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +id));
		
		return modelMapper.map(Hotel, HotelDto.class);
	}

	@Override
	public List<Hotel> getHotelByName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
		// TODO Auto-generated method stub
		log.info("Updationg the hotel with Id",id);
		Hotel Hotel= hotelRepository.findById(id)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +id));
		hotelDto.setId(id);
		Hotel.setId(id);
		modelMapper.map(hotelDto, Hotel);
		Hotel = hotelRepository.save(Hotel);
		
		return modelMapper.map(Hotel, HotelDto.class);
	}

	@Override
	@Transactional
	public void deleteHotelById(Long id) {
		// TODO Auto-generated method stub
		log.info("Deleting the hotel with Id",id);
		
		
		
		Hotel Hotel= hotelRepository.findById(id)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +id));
		
		for(Room room:Hotel.getRooms())
		{
			inventoryService.deleteInventoryByRoomId(room.getId());
			roomService.deleteRoomById(room.getId());
		}
		hotelRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void activateHotel(Long id) {
		// TODO Auto-generated method stub
		
		log.info("Activate the hotel with Id",id);
		Hotel Hotel= hotelRepository.findById(id)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +id));
		
		Hotel.setId(id);
		Hotel.setIsActive(true);
		
		//Hotel = hotelRepository.save(Hotel);
		
		for(Room room:Hotel.getRooms())
		{
			inventoryService.initializeRoomForAYear(room);
		}
		
	}

	@Override
	public HotelInfoDto getHotelInfoById(Long hotelId) {
		// TODO Auto-generated method stub
		Hotel Hotel= hotelRepository.findById(hotelId)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +hotelId));
		
		List<RoomDto> rooms = Hotel.getRooms()
			    .stream()
			    .map(element -> modelMapper.map(element, RoomDto.class))
			    .toList();
		
		return new HotelInfoDto(modelMapper.map(Hotel,HotelDto.class),rooms);
	}

	

	
	
	

}

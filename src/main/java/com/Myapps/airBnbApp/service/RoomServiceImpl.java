package com.Myapps.airBnbApp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.dto.RoomDto;
import com.Myapps.airBnbApp.entity.Hotel;
import com.Myapps.airBnbApp.entity.Room;
import com.Myapps.airBnbApp.repository.HotelRepository;
import com.Myapps.airBnbApp.repository.InventoryRepository;
import com.Myapps.airBnbApp.repository.RoomRepository;

import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private  RoomRepository roomRepository;
	@Autowired
	private  HotelRepository hotelRepository;
	@Autowired
	private InventoryService inventoryService;
	
	private  ModelMapper modelMapper=new ModelMapper();

	@Override
	public List<RoomDto> createNewRoom(Long hotelId, List<RoomDto> roomDto) {
		log.info("Creating the room for hotel Id ",hotelId);
		
		Hotel Hotel= hotelRepository.findById(hotelId)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +hotelId));
		
		/*
		 * Room room=modelMapper.map(roomDto, Room.class); room.setHotel(Hotel);
		 * room=roomRepository.save(room);
		 * 
		 * return modelMapper.map(room, RoomDto.class);
		 */
		
		 List<Room> rooms = roomDto.stream()
		            .map(dto -> {
		                Room room = modelMapper.map(dto, Room.class);
		                room.setHotel(Hotel);
		                return room;
		            })
		            .collect(Collectors.toList());

		    // Save all rooms in one go
		    List<Room> savedRooms = roomRepository.saveAll(rooms);
		    
		    if(Hotel.getIsActive())
    		{
    	     for(Room room:rooms )
    	     {
    	    	 inventoryService.initializeRoomForAYear(room);
    	     }
    		}


		    // Convert list of Room → list of RoomDto
		    return savedRooms.stream()
		            .map(room -> modelMapper.map(room, RoomDto.class))
		            .collect(Collectors.toList());
		    
		   
		
	}

	@Override
	public List<RoomDto> getAllRoomsOfHotel(Long hotelId) {
		
      log.info("Getting all the room for the hotel Id ",hotelId);
		
		Hotel Hotel= hotelRepository.findById(hotelId)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +hotelId));
		
		return Hotel.getRooms().stream()
	            .map(room -> modelMapper.map(room, RoomDto.class))
	            .collect(Collectors.toList());
	}

	@Override
	public RoomDto getRoomById(Long roomId) {
		// TODO Auto-generated method stub
       log.info("Getting room for the room Id ",roomId);
		
		Room room= roomRepository.findById(roomId)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Room not found with Id" +roomId));
		
		return modelMapper.map(room, RoomDto.class);
	}

	@Override
	@Transactional
	public void deleteRoomById(Long roomId) {
		
		log.info("Deleting the room with Id",roomId);
		
		
		Room room= roomRepository.findById(roomId)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Room not found with Id" +roomId));
		inventoryService.deleteInventoryByRoomId(roomId);
		
		roomRepository.deleteById(roomId);
		
	}

}

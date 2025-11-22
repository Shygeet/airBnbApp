package com.Myapps.airBnbApp.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Myapps.airBnbApp.dto.BrowseHotelDto;
import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.entity.Hotel;
import com.Myapps.airBnbApp.entity.Inventory;
import com.Myapps.airBnbApp.entity.Room;
import com.Myapps.airBnbApp.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private final InventoryRepository inventoryRepository;
	

	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public void initializeRoomForAYear(Room room) {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		LocalDate endDate=today.plusYears(1);
		
		for(;!today.isAfter(endDate);today=today.plusDays(1))
		{
			Inventory inventory= Inventory.builder()
					.hotel(room.getHotel())
					.room(room)
					.bookedCount(0)
					.city(room.getHotel().getCity())
					.date(today)
					.isclosed(false)
					.price(room.getBasePrice())
					.surgeFactor(BigDecimal.ONE)
					.totalCount(room.getTotalCount())
					.build();
			
			inventoryRepository.save(inventory);
					
		}
		
	}

	@Override
	public void deleteInventoryByRoomId(Long roomId) {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		inventoryRepository.deleteByRoomId(roomId);
		
	}

	@Override
	public Page<HotelDto> browseHotels(BrowseHotelDto browseHotelDto) {
		// TODO Auto-generated method stub
		log.info("Searching for {} city, from {} to {}", browseHotelDto.getCity(),browseHotelDto.getStartDate(),browseHotelDto.getEndDate());
		
		Pageable pageable = PageRequest.of(browseHotelDto.getPage(), browseHotelDto.getSize());
		
		long dateCount = ChronoUnit.DAYS.between(
	            browseHotelDto.getStartDate(),
	            browseHotelDto.getEndDate()
	    ) + 1;

	    // fetch hotels from repository
	    Page<Hotel> hotelPage = inventoryRepository.findHotelsWithAvailableInventory(
	            browseHotelDto.getCity(),
	            browseHotelDto.getStartDate(),
	            browseHotelDto.getEndDate(),
	            browseHotelDto.getRoomsCount(),
	            dateCount,
	            pageable
	    );

	    // convert Hotel → HotelDto using ModelMapper (or manual mapping)
	    return hotelPage.map(hotel -> modelMapper.map(hotel, HotelDto.class));
	}

}

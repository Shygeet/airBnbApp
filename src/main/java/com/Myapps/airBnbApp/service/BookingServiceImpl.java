package com.Myapps.airBnbApp.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Myapps.airBnbApp.dto.BookingDto;
import com.Myapps.airBnbApp.dto.BookingRequestDto;
import com.Myapps.airBnbApp.dto.GuestDto;
import com.Myapps.airBnbApp.entity.Booking;
import com.Myapps.airBnbApp.entity.Guest;
import com.Myapps.airBnbApp.entity.Hotel;
import com.Myapps.airBnbApp.entity.Inventory;
import com.Myapps.airBnbApp.entity.Room;
import com.Myapps.airBnbApp.entity.User;
import com.Myapps.airBnbApp.entity.Enums.BookingStatus;
import com.Myapps.airBnbApp.repository.BookingRepository;
import com.Myapps.airBnbApp.repository.GuestRepository;
import com.Myapps.airBnbApp.repository.HotelRepository;
import com.Myapps.airBnbApp.repository.InventoryRepository;
import com.Myapps.airBnbApp.repository.RoomRepository;

import exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;
	private final RoomRepository roomRepository;
	private final InventoryRepository inventoryRepository;
	private final HotelRepository hotelRepository;
	private final GuestRepository guestRepository;
	
	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	@Transactional
	public BookingDto initializeBooking(BookingRequestDto bookingRequestDto) {
		// TODO Auto-generated method stub
		Hotel Hotel= hotelRepository.findById(bookingRequestDto.getHotelId())
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Hotel not found with Id" +bookingRequestDto.getHotelId()));
		
		Room room= roomRepository.findById(bookingRequestDto.getRoomId())
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Room not found with Id" +bookingRequestDto.getRoomId()));
		
		List<Inventory> inventoryList=inventoryRepository.findAndLockAvailableInventory(room.getId(), 
				bookingRequestDto.getCheckInDate(), bookingRequestDto.getCheckOutDate(), bookingRequestDto.getRoomsCount());
		
		long dateCount = ChronoUnit.DAYS.between(
				bookingRequestDto.getCheckInDate(),
				bookingRequestDto.getCheckOutDate()
	    ) + 1;
		
		if(inventoryList.size()!= dateCount)
		{
			throw new IllegalStateException("Room is not available not anymore");
		}
		
		for(Inventory inventory: inventoryList)
		{
			inventory.setReservedCount(inventory.getReservedCount()+bookingRequestDto.getRoomsCount());
		}
		inventoryRepository.saveAll(inventoryList);
		
		User user =new User();
		user.setId(1l);
		
		Booking booking=Booking.builder().bookStatus(BookingStatus.Reserved)
				        .hotel(Hotel)
				        .room(room)
				        .checkInDate(bookingRequestDto.getCheckInDate())
				        .checkOutDate(bookingRequestDto.getCheckOutDate())
				        .User(user)
				        .roomsCount(bookingRequestDto.getRoomsCount())
				        .amount(BigDecimal.TEN)
				        .build();
		
		booking = bookingRepository.save(booking);
		
		return modelMapper.map(booking, BookingDto.class);
	}

	@Override
	@Transactional
	public BookingDto addGuests(Long bookingId, List<GuestDto> guests) {
		// TODO Auto-generated method stub
		Booking booking=bookingRepository.findById(bookingId)
				.orElseThrow(()
				-> new ResourceNotFoundException
				("Booking not found with Id" +bookingId));
		
		if(hasBookingExpired(booking))
		{
			throw new IllegalStateException("Booking has already Expired");
		}
		
		if(booking.getBookStatus()!=BookingStatus.Reserved)
		{
			throw new IllegalStateException("Booking Not Reserved as of Now");
		}
		
		for(GuestDto guestDto:guests)
		{
			Guest guest=modelMapper.map(guestDto, Guest.class);
			guest.setUser(getCurrentUser());
			guest=guestRepository.save(guest);
			booking.getGuests().add(guest);
		}
		
		booking.setBookStatus(BookingStatus.GuestAdded);
		booking=bookingRepository.save(booking);
		
		return modelMapper.map(booking,BookingDto.class);
	}
	
	public Boolean hasBookingExpired(Booking booking)
	{
		return booking.getCreated().plusMinutes(10).isBefore(LocalDateTime.now());
	}
	
   public User getCurrentUser() {
	   User user = new User();
	   user.setId(1L);
	   return user;
	   
   }
}

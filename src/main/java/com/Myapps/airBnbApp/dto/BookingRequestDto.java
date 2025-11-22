package com.Myapps.airBnbApp.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookingRequestDto {
	
	private Long hotelId;
	private Long roomId;
	private Integer roomsCount;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	

}

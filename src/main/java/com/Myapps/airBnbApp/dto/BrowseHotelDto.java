package com.Myapps.airBnbApp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BrowseHotelDto {
	
	private String city;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer roomsCount;
	
	private Integer page=0;
	private Integer size=10;

}

package com.Myapps.airBnbApp.dto;

import java.util.List;

import com.Myapps.airBnbApp.entity.HotelContactInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@JsonAutoDetect
public class HotelDto 
{
	private Long id;
	private String name;
	private String city;
	private List<String> amenities;
	private List<String> photos;
	private HotelContactInfo contactInfo;
	private Boolean isActive;

}

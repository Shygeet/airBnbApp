package com.Myapps.airBnbApp.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class HotelContactInfo 
{
	private String address;
	private String phoneNo;
	private String email;
	private String location;
	
}

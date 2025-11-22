package com.Myapps.airBnbApp.dto;

import com.Myapps.airBnbApp.entity.User;
import com.Myapps.airBnbApp.entity.Enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class GuestDto {
	
	
	private User user;
	
	private String name;
	
	private Gender gender;
	
	private Integer age;

}

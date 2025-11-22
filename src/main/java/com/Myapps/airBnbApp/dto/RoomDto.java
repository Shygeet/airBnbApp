package com.Myapps.airBnbApp.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class RoomDto {
	
	private long id;
    private String roomType;
    private BigDecimal basePrice;
    private Integer totalCount;
    private Integer capacity;
 
    

}

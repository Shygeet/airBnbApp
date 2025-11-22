package com.Myapps.airBnbApp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.Myapps.airBnbApp.entity.Guest;
import com.Myapps.airBnbApp.entity.Enums.BookingStatus;

import lombok.Data;

@Data
public class BookingDto {
	
	private long id;

    private Long hotelId;       // Reference instead of entire Hotel entity
    private Long roomId;        // Reference instead of entire Room entity
    private Long userId;        // Reference instead of entire User entity

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;


    private BookingStatus bookStatus;

    private LocalDateTime created;
    private LocalDateTime updated;

    private Set<GuestDto> guests;

}

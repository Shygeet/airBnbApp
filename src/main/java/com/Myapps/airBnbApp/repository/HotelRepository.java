package com.Myapps.airBnbApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myapps.airBnbApp.dto.HotelDto;
import com.Myapps.airBnbApp.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	

}

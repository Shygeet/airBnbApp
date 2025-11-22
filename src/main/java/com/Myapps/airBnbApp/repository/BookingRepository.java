package com.Myapps.airBnbApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myapps.airBnbApp.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}

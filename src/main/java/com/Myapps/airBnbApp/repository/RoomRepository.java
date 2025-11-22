package com.Myapps.airBnbApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myapps.airBnbApp.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}

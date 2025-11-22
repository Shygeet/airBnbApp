package com.Myapps.airBnbApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Myapps.airBnbApp.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>  {

}

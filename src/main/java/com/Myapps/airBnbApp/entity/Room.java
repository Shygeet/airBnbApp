package com.Myapps.airBnbApp.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="hotel_id",nullable = false)
	private Hotel hotel;
	
	@Column(nullable = false)
	private String roomType;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal basePrice;
	
	@Column(nullable = false)
	private Integer totalCount;
	
	@Column(nullable = false)
	private Integer Capacity;
	

	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime created ;
	
	@UpdateTimestamp
	private LocalDateTime updated ;
	
	
	

}

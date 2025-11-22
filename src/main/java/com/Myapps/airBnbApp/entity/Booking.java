package com.Myapps.airBnbApp.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.Myapps.airBnbApp.entity.Enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hotel_id",nullable = false)
	private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="room_id",nullable = false)
	private Room room;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable = false)
	private User User;
	
	@Column(nullable = false)
	private LocalDate checkInDate;
	
	@Column(nullable = false)
	private LocalDate checkOutDate;
	
	@Column(nullable = false)
	private Integer roomsCount;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BookingStatus bookStatus;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime created ;
	
	@UpdateTimestamp
	private LocalDateTime updated ;
	
	
	
	@ManyToMany
	@JoinTable(name="booking_guest",
	joinColumns = @JoinColumn(name="booking_id"),
	inverseJoinColumns =@JoinColumn(name="guest_id") )
	private Set<Guest> guests;
	
    private BigDecimal amount;

}

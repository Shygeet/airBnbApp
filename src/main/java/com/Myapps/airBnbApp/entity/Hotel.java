package com.Myapps.airBnbApp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "hotel")
public class Hotel
{
	
	
	

	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    //@NotBlank(message = "Hotel name cannot be blank")
	    @Size(max = 100, message = "Hotel name must be less than 100 characters")
	    @Column(nullable = false, length = 100)
	    private String name;

	    //@NotBlank(message = "City cannot be blank")
	    @Size(max = 50, message = "City name must be less than 50 characters")
	    @Column(nullable = false, length = 50)
	    private String city;

	    // Example: List of image URLs (can be stored as a JSON string or separate table)
	    @ElementCollection
	    @CollectionTable(name = "hotel_photos", joinColumns = @JoinColumn(name = "hotel_id"))
	    @Column(name = "photo_url")
	    private List<String> photos;

	    
		// Example: amenities like "WiFi", "Pool", "Parking"
	    @ElementCollection
	    @CollectionTable(name = "hotel_amenities", joinColumns = @JoinColumn(name = "hotel_id"))
	    @Column(name = "amenity")
	    private List<String> amenities;

	    @NotNull
	    @Column(name = "created_at", nullable = false, updatable = false)
	    private LocalDateTime createdAt;

	    @NotNull
	    @Column(name = "updated_at", nullable = false)
	    private LocalDateTime updatedAt;

	    // Automatically set timestamps
	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	        updatedAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }

	    // Constructors
	    public Hotel() {}

	    public Hotel(String name, String city, List<String> photos, List<String> amenities) {
	        this.name = name;
	        this.city = city;
	        this.photos = photos;
	        this.amenities = amenities;
	    }

	
	    @Embedded
	    private HotelContactInfo contactInfo;

	    @Column(nullable = false)
		private Boolean isActive;
	    
	    
	    @OneToMany(mappedBy = "hotel")
	    private List<Room> rooms;

}

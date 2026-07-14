package com.MilkShop.Pro.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class MilkEntiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private CustModel customer;
	
	private float morningQty = 0.0f;
	private float morningFat = 0.0f;
	private float eveningFat = 0.0f;
	private float eveningQty = 0.0f;
	private float morcost=0.0f;
	private float evecost=0.0f;
	private float totalcost=0.0f;	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	
}

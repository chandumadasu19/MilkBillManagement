package com.MilkShop.Pro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CustModel {
	
	public CustModel(int custid) {
		// TODO Auto-generated constructor stub
	}
	public CustModel() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	long number;
}

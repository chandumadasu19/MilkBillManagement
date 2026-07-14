package com.MilkShop.Pro.Request;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class findByIdDate {
	
	public int id;
	public LocalDate date;

}

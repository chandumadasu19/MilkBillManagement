package com.MilkShop.Pro.Request;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EveBill {

	public int custid;
	public float evefat;
	public float eveqty;
	public LocalDate date;
}

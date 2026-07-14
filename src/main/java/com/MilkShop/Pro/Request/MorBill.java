package com.MilkShop.Pro.Request;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MorBill {
	
	public int custid;
	public float morfat;
	public float morqty;
	public LocalDate date;

}

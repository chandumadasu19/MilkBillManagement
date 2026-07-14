package com.MilkShop.Pro.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MilkShop.Pro.Request.EveBill;
import com.MilkShop.Pro.Request.MorBill;
import com.MilkShop.Pro.Request.findByIdDate;
import com.MilkShop.Pro.model.MilkEntiry;
import com.MilkShop.Pro.service.Milkentryserv;

@RestController
@RequestMapping("api/milk")
@CrossOrigin(origins = "http://localhost:3000")
public class MilkBillCont {

	@Autowired
	Milkentryserv ser;
	
	@PostMapping("/MorBill")
	public ResponseEntity<MilkEntiry> MorningBill(@RequestBody MorBill data){
		
		MilkEntiry savedData = ser.MoringBill(data);
		
		return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedData);
	}
	@PostMapping("/EveBill")
	public ResponseEntity<MilkEntiry> EveBill(@RequestBody EveBill data){
        MilkEntiry savedData = ser.EveBill(data);
		
		return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedData);
		
	}
	
	@PostMapping("/GetByIdandDate")
	public ResponseEntity<MilkEntiry> getByIdandDate(@RequestBody findByIdDate data){
		
		MilkEntiry RecivData = ser.getByIdandDate(data);
		System.out.println(RecivData);
		if(RecivData == null) {
			 return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(RecivData);
		
	}
	@GetMapping("/TodaysList/{date}")
	public ResponseEntity<List<MilkEntiry>> todaysList(@PathVariable LocalDate date){
		
		List<MilkEntiry> list = ser.TodaysList(date);
		if(list == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/From-There/{fdate}/{tdate}/{id}")
	public ResponseEntity<List<MilkEntiry>> fromToThere(@PathVariable("fdate") LocalDate fdate, @PathVariable("tdate") LocalDate tdate, @PathVariable("id") int id){
		
		List<MilkEntiry> list =ser.fromToThere(fdate,tdate,id);
		if(list.size()==0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}
}

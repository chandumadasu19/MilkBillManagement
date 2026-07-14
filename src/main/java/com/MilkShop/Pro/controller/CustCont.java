package com.MilkShop.Pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MilkShop.Pro.model.CustModel;
import com.MilkShop.Pro.service.CustomServ;

@RestController
@RequestMapping("api/cust")
@CrossOrigin(origins = "http://localhost:3000")
public class CustCont {

	@Autowired
	CustomServ ser;
	
	@PostMapping("/Add")
	public ResponseEntity<CustModel> AddUser(@RequestBody CustModel cust){
		
		CustModel cust1 = ser.adduser(cust);
	    return ResponseEntity.status(HttpStatus.CREATED)
                .body(cust1);

	}
	@GetMapping("/FindById/{id}")
	public ResponseEntity<CustModel> findById(@PathVariable int id){
		CustModel cust=ser.findById(id);
		if(cust== null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cust);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustModel> updateCust(@PathVariable int id){
		CustModel cust = ser.delCust(id);
		if(cust != null) {
			return ResponseEntity.ok(cust);
		}
		return ResponseEntity.notFound().build();
	}
}

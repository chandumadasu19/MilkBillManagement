package com.MilkShop.Pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MilkShop.Pro.model.CustModel;
import com.MilkShop.Pro.repo.CustRepo;

@Service
public class CustomServ {

	@Autowired
	CustRepo repo;

	public CustModel adduser(CustModel cust) {
		// TODO Auto-generated method stub
		return repo.save(cust);
	}

	public CustModel findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
		
	}
}

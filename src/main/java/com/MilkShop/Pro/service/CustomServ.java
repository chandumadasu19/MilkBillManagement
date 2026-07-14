package com.MilkShop.Pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MilkShop.Pro.Request.CustDel;
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

	public CustModel delCust(int id) {
		
		return repo.delById(id);
	}

	public CustModel updateCust(CustDel cust) {
		CustModel res = findById(cust.getId());
		if(res !=null) {
			res.setName(cust.getName());
			res.setNumber(cust.getNumber());
			return repo.save(res);	
			}
		return null;
	}
}

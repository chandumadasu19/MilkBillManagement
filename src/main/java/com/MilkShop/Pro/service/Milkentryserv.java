package com.MilkShop.Pro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MilkShop.Pro.Request.EveBill;
import com.MilkShop.Pro.Request.MorBill;
import com.MilkShop.Pro.Request.findByIdDate;
import com.MilkShop.Pro.model.CustModel;
import com.MilkShop.Pro.model.MilkEntiry;
import com.MilkShop.Pro.repo.CustRepo;
import com.MilkShop.Pro.repo.MilkBilRepo;

@Service
public class Milkentryserv {

	@Autowired 
	MilkBilRepo repo;
	@Autowired
	CustRepo custrepo;



	public MilkEntiry MoringBill(MorBill data) {
		
		CustModel cust = custrepo.findById(data.getCustid())
		        .orElseThrow(() -> new RuntimeException("Customer not found"));
		MilkEntiry Bill = isPresnt(cust, data.getDate());
		float price = priceForFat(data.getMorfat())*data.getMorqty();
		
       if(Bill != null) {
		
		Bill.setCreatedDate(data.getDate());
		Bill.setCustomer(cust);
		Bill.setMorningFat(data.getMorfat());
		Bill.setMorningQty(data.getMorqty());
		Bill.setMorcost(price);
		Bill.setTotalcost(price+Bill.getEvecost());
       }
       else {
    	   Bill = new MilkEntiry();
   		Bill.setCreatedDate(data.getDate());
   		Bill.setCustomer(cust);
   		Bill.setMorningFat(data.getMorfat());
   		Bill.setMorningQty(data.getMorqty());
   		Bill.setMorcost(price);
   		Bill.setTotalcost(price+Bill.getEvecost());
       }
		
		return repo.save(Bill);
	}

	private MilkEntiry isPresnt(CustModel cust, LocalDate date) {
		return repo.findByCustomerAndCreatedDate(cust,date);
	}

	private float priceForFat(float fat) {
		
		if((fat>=4.5) && (fat <5.5) ) {
			return (float) 50.0;
		}
		else if((fat>=5.5) && (fat <6.5)) {
			return (float) 60.0;
		}
		
		else if((fat>=6.5) && (fat <7.5)) {
			return (float)70.0;
		}
		
		return 0;
	}

	public MilkEntiry EveBill(EveBill data) {
		
		CustModel cust = custrepo.findById(data.getCustid())
		        .orElseThrow(() -> new RuntimeException("Customer not found"));
		float price = priceForFat(data.getEvefat())*data.getEveqty();
		MilkEntiry ExsistsData= isPresnt(cust, data.getDate());
		if(ExsistsData != null) {
			ExsistsData.setEveningFat(data.getEvefat());
			ExsistsData.setEveningQty(data.getEveqty());
			ExsistsData.setEvecost(price);
			ExsistsData.setTotalcost(price+ExsistsData.getTotalcost());
		}
		else {
			ExsistsData.setEveningFat(data.getEvefat());
			ExsistsData.setCreatedDate(data.getDate());
			ExsistsData.setCustomer(cust);
			ExsistsData.setEveningQty(data.getEveqty());
			ExsistsData.setEvecost(price);
			ExsistsData.setTotalcost(price);
		}
		
		return repo.save(ExsistsData);
	}

	

	public MilkEntiry getByIdandDate(findByIdDate data) {
		CustModel cust = custrepo.findById(data.getId())
		        .orElseThrow(() -> new RuntimeException("Customer not found"));
	
		return isPresnt(cust, data.getDate());
	}

	public List<MilkEntiry> TodaysList(LocalDate date) {
	
		return repo.findAllByCreatedDate(date);
	}

	public List<MilkEntiry> fromToThere(LocalDate fdate, LocalDate tdate, int id) {
		if(id>=1) {
			CustModel cust = custrepo.findById(id)
			        .orElse(null);
			if(cust == null) {
				return null;
			}
			return repo.findFomToThere(fdate, tdate, cust);
		}
		return repo.findFomToThere(fdate,tdate);
	}

	


}

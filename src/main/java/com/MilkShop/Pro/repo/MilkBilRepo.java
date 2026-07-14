package com.MilkShop.Pro.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MilkShop.Pro.model.CustModel;
import com.MilkShop.Pro.model.MilkEntiry;

public interface MilkBilRepo extends JpaRepository<MilkEntiry,Integer>{

	

	MilkEntiry findByCustomerAndCreatedDate(CustModel cust, LocalDate date);

	List<MilkEntiry> findAllByCreatedDate(LocalDate date);
    
	@Query("select e from MilkEntiry e where e.customer=?3 and e.createdDate between ?1 and ?2")
	List<MilkEntiry> findFomToThere(LocalDate fdate, LocalDate tdate, CustModel cust);
	@Query("select e from MilkEntiry e where e.createdDate between ?1 and ?2")
	List<MilkEntiry> findFomToThere(LocalDate fdate, LocalDate tdate);

}

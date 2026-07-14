package com.MilkShop.Pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MilkShop.Pro.model.CustModel;

public interface CustRepo extends JpaRepository<CustModel, Integer> {

	@Query("update CustModel set isDel=false where id=?1")
	CustModel delById(int id);

}

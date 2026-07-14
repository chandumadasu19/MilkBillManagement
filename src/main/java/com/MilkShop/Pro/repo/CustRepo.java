package com.MilkShop.Pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MilkShop.Pro.model.CustModel;

public interface CustRepo extends JpaRepository<CustModel, Integer> {

}

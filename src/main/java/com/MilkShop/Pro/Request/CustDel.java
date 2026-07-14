
package com.MilkShop.Pro.Request;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component 
@Data
@AllArgsConstructor
public class CustDel {
	
	public int id;
	public String name;
	public int number;

}

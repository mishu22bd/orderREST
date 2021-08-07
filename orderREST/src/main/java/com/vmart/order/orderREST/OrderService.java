package com.vmart.order.orderREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository inv;

    
	public List<OrderFinal> ListAll() {
       return inv.findAll();		
		
	}
	
   public void save(OrderFinal order) {
   		inv.save(order);

   	}
   
 public OrderFinal get(Integer id) {
	 return inv.findById(id).get();
	 	 
    }
 
 public void delete(Integer id) {
	 inv.deleteById(id);
	 
   }
   
   
   
}

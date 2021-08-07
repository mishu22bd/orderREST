package com.vmart.order.orderREST;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderFinal, Integer> {
	
	

}

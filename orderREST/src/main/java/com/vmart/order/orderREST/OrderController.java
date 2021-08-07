package com.vmart.order.orderREST;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping("/order")
	public List<OrderFinal> list() {
		return service.ListAll();
		
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderFinal> get(@PathVariable Integer id) {
		try {
	   OrderFinal order = service.get(id);
	   return new ResponseEntity<OrderFinal>(order, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			 return new ResponseEntity<OrderFinal>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/order")
	public void add(@RequestBody OrderFinal order) {
		
		service.save(order);
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<?> update(@RequestBody OrderFinal order, @PathVariable Integer id) {
		
		try {
			OrderFinal exisOrder = service.get(id);
		service.save(order);
		    return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/order/{id}")
	
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}

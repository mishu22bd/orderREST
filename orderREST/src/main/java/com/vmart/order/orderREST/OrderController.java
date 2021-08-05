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
	public List<Order> list() {
		return service.ListAll();
		
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> get(@PathVariable Integer id) {
		try {
	   Order order = service.get(id);
	   return new ResponseEntity<Order>(order, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			 return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/order")
	public void add(@RequestBody Order order) {
		service.save(order);
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Integer id) {
		
		try {
			Order exisOrder = service.get(id);
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

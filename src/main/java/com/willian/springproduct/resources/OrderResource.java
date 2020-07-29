package com.willian.springproduct.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.willian.springproduct.domain.Order;
import com.willian.springproduct.services.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping
	@ApiOperation(value="Return a list of orders")
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="{id}")
	@ApiOperation(value="Return an order by id")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ApiOperation(value="Insert a new order")
	public ResponseEntity<Order> insert(@RequestBody Order obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="{id}")
	@ApiOperation(value="Delete an order by id")
	public ResponseEntity<Order> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="{id}")
	@ApiOperation(value="Update an order by id")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}

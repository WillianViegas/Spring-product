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

import com.willian.springproduct.domain.Adress;
import com.willian.springproduct.domain.Provider;
import com.willian.springproduct.services.ProviderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/providers")	
public class ProviderResource {
	
	@Autowired
	private ProviderService service;
	
	@GetMapping
	@ApiOperation(value="Return a provider list")
	public ResponseEntity<List<Provider>> findAll(){
		List<Provider> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="{id}")
	@ApiOperation(value="Return a provider by id")
	public ResponseEntity<Provider> findById(@PathVariable Long id){
		Provider obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/adress")
	@ApiOperation(value="Return a adress provider list")
	public ResponseEntity<List<Adress>> findAllAdress(){
		List<Adress> list = service.findAllAdress();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	@ApiOperation(value="Insert a new provider")
	public ResponseEntity<Provider> insert(@RequestBody Provider obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
	
	@DeleteMapping(value="{id}")
	@ApiOperation(value="Delete a provider by id")
	public ResponseEntity<Provider> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="{id}")
	@ApiOperation(value="Update a provider by id")
	public ResponseEntity<Provider> update(@PathVariable Long id, @RequestBody Provider obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}

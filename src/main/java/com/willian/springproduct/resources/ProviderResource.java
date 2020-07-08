package com.willian.springproduct.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willian.springproduct.domain.Provider;
import com.willian.springproduct.services.ProviderService;

@RestController
@RequestMapping(value="/providers")
public class ProviderResource {
	
	@Autowired
	private ProviderService service;
	
	@GetMapping
	public ResponseEntity<List<Provider>> findAll(){
		List<Provider> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Provider> findById(@PathVariable Long id){
		Provider obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

package com.willian.springproduct.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.willian.springproduct.domain.Order;
import com.willian.springproduct.repositories.OrderItemRepository;
import com.willian.springproduct.repositories.OrderRepository;
import com.willian.springproduct.services.exception.DataBaseException;
import com.willian.springproduct.services.exception.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
		catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	
	}

	private void updateData(Order entity, Order obj) {
		entity.setStatus(obj.getStatus());
		entity.setMoment(obj.getMoment());
	}
}

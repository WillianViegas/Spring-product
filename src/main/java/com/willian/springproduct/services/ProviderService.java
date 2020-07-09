package com.willian.springproduct.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.willian.springproduct.domain.Adress;
import com.willian.springproduct.domain.Provider;
import com.willian.springproduct.repositories.AdressRepository;
import com.willian.springproduct.repositories.ProviderRepository;
import com.willian.springproduct.services.exception.DataBaseException;
import com.willian.springproduct.services.exception.ObjectNotFoundException;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository repository;
	
	@Autowired AdressRepository adressRepository;
	
	public List<Provider> findAll(){
		return repository.findAll();
	}
	
	public Provider findById(Long id) {
		Optional<Provider> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Adress> findAllAdress(){
		return adressRepository.findAll();
	}
	
	public Provider insert(Provider obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EntityNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
}

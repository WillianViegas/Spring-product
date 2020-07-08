package com.willian.springproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.springproduct.domain.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}

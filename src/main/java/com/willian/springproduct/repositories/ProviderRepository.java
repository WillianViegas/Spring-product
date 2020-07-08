package com.willian.springproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.springproduct.domain.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}

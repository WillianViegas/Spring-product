package com.willian.springproduct.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.willian.springproduct.domain.Product;
import com.willian.springproduct.domain.Provider;
import com.willian.springproduct.repositories.ProductRepository;
import com.willian.springproduct.repositories.ProviderRepository;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner{

	@Autowired
	private ProductRepository prodRepository;
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product(null,"TV", "40 polegadas", 1500.00);
		Product p2 = new Product(null,"Notebook", "intel i5", 2000.00);
		Product p3 = new Product(null,"Videogame", "playstation 4", 1800.00);
		
		prodRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Provider pr1 = new Provider(null, "Casas Bahia", "330405968");
		Provider pr2 = new Provider(null, "Extra", "0000000");
		Provider pr3 = new Provider(null, "Magalu", "32333338");
		
		providerRepository.saveAll(Arrays.asList(pr1, pr2, pr3));
	}

}

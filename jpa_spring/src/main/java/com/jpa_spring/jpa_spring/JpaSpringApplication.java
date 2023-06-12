package com.jpa_spring.jpa_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.jpa_spring.classes.Customer;
import com.jpa_spring.classes.CustomerRepository;

@SpringBootApplication
public class JpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringApplication.class, args);
	}
	
	 @Bean
	  public CommandLineRunner demo(CustomerRepository repository) {
	    return (args) -> {
	      // Alguns customers
	      repository.save(new Customer("Jack", "Bauer"));
	      repository.save(new Customer("Chloe", "O'Brian"));
	      repository.save(new Customer("Kim", "Bauer"));
	      repository.save(new Customer("David", "Palmer"));
	      repository.save(new Customer("Michelle", "Dessler"));

	      // selecionar todos os customers
	      repository.findAll();

	      // seleciona pelo ID
	      Customer customer = repository.findById(1L);
	      
	      // seleciona pelo sobrenome
	      repository.findByLastName("Bauer");
	    };
	  }
	
}

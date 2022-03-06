package com.java.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Bank;

import reactor.core.publisher.Flux;

@Repository
public interface BankRepository extends ReactiveCrudRepository<Bank, Long> {
    @Query(value = "SELECT * FROM banks WHERE bank_name= :name")
	Flux<Bank> findAllByName(String name);
	
}

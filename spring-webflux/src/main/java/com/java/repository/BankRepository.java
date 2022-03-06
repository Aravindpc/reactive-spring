package com.java.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.java.model.Bank;
 
public interface BankRepository extends ReactiveMongoRepository<Bank, Integer> {

}
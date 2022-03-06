package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Bank;
import com.java.repository.BankRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@Service
public class BankService {
     
    @Autowired
    private BankRepository bankRepository;
 
    public Mono<Bank> create(Bank bank) {
        return bankRepository.save(bank);
    }
 
    public Mono<Bank> findById(Integer id) {
        return bankRepository.findById(id);
    }
 
    public Flux<Bank> findAll() {
        return bankRepository.findAll();
    }
 
    public Mono<Bank> update(Bank e) {
        return bankRepository.save(e);
    }
 
    public Mono<Void> delete(Integer id) {
        return bankRepository.deleteById(id);
    }
 
}
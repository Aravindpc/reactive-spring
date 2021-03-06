package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Bank;
import com.java.service.BankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@RestController
public class BankController {
    @Autowired
    private BankService bankService;
 
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Bank> create(@RequestBody Bank bank) {
    	System.out.println(bank);
        return bankService.create(bank);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Bank>> findById(@PathVariable("id") Integer id) {
        Mono<Bank> bank = bankService.findById(id);
        HttpStatus status = bank != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Bank>>(bank, status);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Bank> findAll() {
        Flux<Bank> banks = bankService.findAll();
        return banks;
    }
 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Bank> update(@RequestBody Bank bank) {
        return bankService.update(bank);
    }
 
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        bankService.delete(id).subscribe();
    }
 
}

package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.model.Bank;
import com.java.service.BankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class BankController {
	@Autowired
    private BankService bankService;
  
    @GetMapping("/{bankID}")
    public Mono<ResponseEntity<Bank>> getBank(@PathVariable Long bankID) {
        return bankService.findById(bankID).map(bank -> {
            return new ResponseEntity<>(bank, HttpStatus.OK);
        });
    }

    @SuppressWarnings("deprecation")
	@GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Bank> getBanks(@RequestParam(value = "name", defaultValue = "a") String name) {
      

        return bankService.findAllByName(name).delayElements(Duration.ofSeconds(2L));
    }

    @PostMapping
    public ResponseEntity<Mono<Bank>> addBank(@RequestBody Bank bank) {

        return new ResponseEntity<>(bankService.create(bank),HttpStatus.OK);
    }

    @PutMapping("/{bankID}")
    public ResponseEntity<Mono<Bank>> updateBank(@PathVariable Long bankID, @RequestBody Bank bank) {

        return new ResponseEntity<>(bankService.findById(bankID),HttpStatus.OK);

    }

    @DeleteMapping("/{bankID}")
    public ResponseEntity<Mono<Void>> deleteBank(@PathVariable Long bankID) {
    	Mono<Void> bank=bankService.delete(bankID);
        return new ResponseEntity<>(bank,HttpStatus.OK);
      }
}

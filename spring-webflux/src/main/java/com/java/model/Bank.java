package com.java.model;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
 
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Bank {
 
	public Bank(@JsonProperty("id")long id, @JsonProperty("bank_reg_number")String bank_reg_number, @JsonProperty("bank_identification_code")String bank_identification_code, @JsonProperty("bank_name")String bank_name, @JsonProperty("country")String country,
			@JsonProperty("registered_address")String registered_address, @JsonProperty("maker_date")LocalDateTime maker_date,@JsonProperty("checker_date") LocalDateTime checker_date, @JsonProperty("maker_id")String maker_id,
			@JsonProperty("checker_id")String checker_id, @JsonProperty("modified_by")String modified_by, @JsonProperty("modified_date")LocalDateTime modified_date) {
		super();
		this.id = id;
		this.bank_reg_number = bank_reg_number;
		this.bank_identification_code = bank_identification_code;
		this.bank_name = bank_name;
		this.country = country;
		this.registered_address = registered_address;
		this.maker_date = maker_date;
		this.checker_date = checker_date;
		this.maker_id = maker_id;
		this.checker_id = checker_id;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	@Id
	
	private long id;
	
	
	private String bank_reg_number;

	
	private String bank_identification_code;
	
	
	private String bank_name;
	

	private String country;
	
	
	private String registered_address;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime maker_date;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checker_date;
	
	
	private String maker_id;
	
	
	private String checker_id;
	
	
	private String modified_by;

	
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modified_date;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getBank_reg_number() {
		return bank_reg_number;
	}


	public void setBank_reg_number(String bank_reg_number) {
		this.bank_reg_number = bank_reg_number;
	}


	public String getBank_identification_code() {
		return bank_identification_code;
	}


	public void setBank_identification_code(String bank_identification_code) {
		this.bank_identification_code = bank_identification_code;
	}


	public String getBank_name() {
		return bank_name;
	}


	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRegistered_address() {
		return registered_address;
	}


	public void setRegistered_address(String registered_address) {
		this.registered_address = registered_address;
	}


	public LocalDateTime getMaker_date() {
		return maker_date;
	}


	public void setMaker_date(LocalDateTime maker_date) {
		this.maker_date = maker_date;
	}


	public LocalDateTime getChecker_date() {
		return checker_date;
	}


	public void setChecker_date(LocalDateTime checker_date) {
		this.checker_date = checker_date;
	}


	public String getMaker_id() {
		return maker_id;
	}


	public void setMaker_id(String maker_id) {
		this.maker_id = maker_id;
	}


	public String getChecker_id() {
		return checker_id;
	}


	public void setChecker_id(String checker_id) {
		this.checker_id = checker_id;
	}


	public String getModified_by() {
		return modified_by;
	}


	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}


	public LocalDateTime getModified_date() {
		return modified_date;
	}


	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}
	
	
}

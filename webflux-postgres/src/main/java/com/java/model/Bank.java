package com.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("banks")
public class Bank {
	public Bank(String bank_reg_number, String bank_identification_code, String bank_name, String country,
			String registered_address, LocalDateTime maker_date, LocalDateTime checker_date, String maker_id,
			String checker_id, String modified_by, LocalDateTime modified_date) {
		super();
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
	@Column("bank_id")	
	private long id;
	
	@Column("bank_reg_number")
	private String bank_reg_number;

	@Column("bank_identification_code")
	private String bank_identification_code;
	
	@Column("bank_name")
	private String bank_name;
	
	@Column("country")
	private String country;
	
	@Column("registered_address")
	private String registered_address;
	
	@Column("maker_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime maker_date;
	
	@Column("checker_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checker_date;
	
	@Column("maker_id")
	private String maker_id;
	
	@Column("checker_id")
	private String checker_id;
	
	@Column("modified_by")
	private String modified_by;

	@Column("modified_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modified_date;
}

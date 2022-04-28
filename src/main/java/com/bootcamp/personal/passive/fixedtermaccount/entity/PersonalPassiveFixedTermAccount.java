package com.bootcamp.personal.passive.fixedtermaccount.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PersonalPassiveFixedTermAccount {
	
	@Id
	private String id;
	private String accountNumber; //"001207420200355458"
    private PersonalClient documentNumber;
    private String depositDate;
    private String withdrawalDate;
    private String percent; //50
    private String months;
    
}

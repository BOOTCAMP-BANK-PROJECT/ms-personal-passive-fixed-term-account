package com.bootcamp.personal.passive.fixedtermaccount.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccount;

import reactor.core.publisher.Mono;

public interface PersonalPassiveFixedTermAccountRepository extends ReactiveCrudRepository<PersonalPassiveFixedTermAccount, String> {
	
	Mono<PersonalPassiveFixedTermAccount> findByDocumentNumber(String num);

}

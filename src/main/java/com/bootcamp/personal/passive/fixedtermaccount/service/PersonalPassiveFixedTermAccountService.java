package com.bootcamp.personal.passive.fixedtermaccount.service;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalPassiveFixedTermAccountService {
	
    Flux<PersonalPassiveFixedTermAccount> findAll();
    Mono<PersonalPassiveFixedTermAccount> create(PersonalPassiveFixedTermAccount fixed);
    Mono<PersonalPassiveFixedTermAccount> findByDocumentNumber(String num);
    Mono<PersonalPassiveFixedTermAccount> update(PersonalPassiveFixedTermAccount fixed);
    Mono<Void> deleteById(String id);

}

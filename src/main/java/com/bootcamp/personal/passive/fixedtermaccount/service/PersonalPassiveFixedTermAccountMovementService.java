package com.bootcamp.personal.passive.fixedtermaccount.service;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccountMovement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalPassiveFixedTermAccountMovementService {
	
    Flux<PersonalPassiveFixedTermAccountMovement> findAll();
    Mono<PersonalPassiveFixedTermAccountMovement> create(PersonalPassiveFixedTermAccountMovement fixedm);
    Flux<PersonalPassiveFixedTermAccountMovement> findByDocumentNumber(String num);
    Mono<PersonalPassiveFixedTermAccountMovement> update(PersonalPassiveFixedTermAccountMovement fixedm);
    Mono<Void> deleteById(String id);

}

package com.bootcamp.personal.passive.fixedtermaccount.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccountMovement;

import reactor.core.publisher.Flux;

public interface PersonalPassiveFixedTermAccountMovementRepository extends ReactiveCrudRepository<PersonalPassiveFixedTermAccountMovement, String> {
	
	Flux<PersonalPassiveFixedTermAccountMovement> findByDocumentNumber(String num);

}

package com.bootcamp.personal.passive.fixedtermaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccountMovement;
import com.bootcamp.personal.passive.fixedtermaccount.repository.PersonalPassiveFixedTermAccountMovementRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonalPassiveFixedTermAccountMovementServiceImpl implements PersonalPassiveFixedTermAccountMovementService {
	
	@Autowired
    public final PersonalPassiveFixedTermAccountMovementRepository repo;

	@Override
	public Flux<PersonalPassiveFixedTermAccountMovement> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repo.deleteById(id);
	}

	@Override
	public Flux<PersonalPassiveFixedTermAccountMovement> findByDocumentNumber(String num) {
		return repo.findByDocumentNumber(num);
	}

	@Override
	public Mono<PersonalPassiveFixedTermAccountMovement> create(PersonalPassiveFixedTermAccountMovement fixedm) {
		return repo.save(fixedm);
	}

	@Override
	public Mono<PersonalPassiveFixedTermAccountMovement> update(PersonalPassiveFixedTermAccountMovement fixedm) {
		return repo.save(fixedm);
	}

}

package com.bootcamp.personal.passive.fixedtermaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccount;
import com.bootcamp.personal.passive.fixedtermaccount.repository.PersonalPassiveFixedTermAccountRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonalPassiveFixedTermAccountServiceImpl implements PersonalPassiveFixedTermAccountService {
	
	@Autowired
    public final PersonalPassiveFixedTermAccountRepository repo;

	@Override
	public Flux<PersonalPassiveFixedTermAccount> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repo.deleteById(id);
	}

	@Override
	public Mono<PersonalPassiveFixedTermAccount> create(PersonalPassiveFixedTermAccount fixed) {
		return repo.save(fixed);
	}

	@Override
	public Mono<PersonalPassiveFixedTermAccount> update(PersonalPassiveFixedTermAccount fixed) {
		return repo.save(fixed);
	}

	@Override
	public Mono<PersonalPassiveFixedTermAccount> findByDocumentNumber(String num) {
		return repo.findByDocumentNumber(num);
	}

}

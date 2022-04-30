package com.bootcamp.personal.passive.fixedtermaccount.repository;

import com.bootcamp.personal.passive.fixedtermaccount.entity.FixedTermAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FixedTermAccountRepository extends ReactiveMongoRepository<FixedTermAccount, String> {

    Mono<FixedTermAccount> findByIdClient(String idClient);
}
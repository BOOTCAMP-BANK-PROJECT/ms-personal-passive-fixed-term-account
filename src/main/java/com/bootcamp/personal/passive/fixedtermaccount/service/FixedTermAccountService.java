package com.bootcamp.personal.passive.fixedtermaccount.service;

import com.bootcamp.personal.passive.fixedtermaccount.entity.FixedTermAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface FixedTermAccountService {

    public Flux<FixedTermAccount> getAll();

    public Mono<FixedTermAccount> getById(String id);

    public Mono<FixedTermAccount> save(FixedTermAccount FfxedTermAccount);

    public Mono<FixedTermAccount> update(FixedTermAccount FfxedTermAccount);

    public Mono<FixedTermAccount> delete(String id);
}
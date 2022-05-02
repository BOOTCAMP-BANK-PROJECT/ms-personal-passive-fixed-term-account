package com.bootcamp.personal.passive.fixedtermaccount.service.impl;

import com.bootcamp.personal.passive.fixedtermaccount.entity.FixedTermAccount;
import com.bootcamp.personal.passive.fixedtermaccount.repository.FixedTermAccountRepository;
import com.bootcamp.personal.passive.fixedtermaccount.service.FixedTermAccountService;
import com.bootcamp.personal.passive.fixedtermaccount.util.Constant;
import com.bootcamp.personal.passive.fixedtermaccount.util.handler.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class FixedTermAccountServiceImpl implements FixedTermAccountService {

    public final FixedTermAccountRepository repository;

    @Override
    public Flux<FixedTermAccount> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<FixedTermAccount> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<FixedTermAccount> save(FixedTermAccount fixedTermAccount) {
        return repository.findByIdClient(fixedTermAccount.getIdClient())
                .map(sa -> {
                    throw new BadRequestException(
                            "ID",
                            "Client have one ore more accounts",
                            sa.getId(),
                            FixedTermAccountServiceImpl.class,
                            "save.onErrorResume"
                    );
                })
                .switchIfEmpty(Mono.defer(() -> {
                    fixedTermAccount.setId(null);
                    fixedTermAccount.setInsertionDate(new Date());
                    return repository.save(fixedTermAccount);
                     }
                ))
                .onErrorResume(e -> Mono.error(e)).cast(FixedTermAccount.class);
    }

    @Override
    public Mono<FixedTermAccount> update(FixedTermAccount fixedTermAccount) {

        return repository.findById(fixedTermAccount.getId())
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + fixedTermAccount.getId() + " was not found. >> switchIfEmpty")))
                .flatMap(p -> repository.save(fixedTermAccount))
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to update an item.",
                        e.getMessage(),
                        FixedTermAccountServiceImpl.class,
                        "update.onErrorResume"
                )));
    }

    @Override
    public Mono<FixedTermAccount> delete(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + id + " was not found. >> switchIfEmpty")))
                .flatMap(p -> {
                    p.setRegistrationStatus(Constant.STATUS_INACTIVE);
                    return repository.save(p);
                })
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to delete an item.",
                        e.getMessage(),
                        FixedTermAccountServiceImpl.class,
                        "update.onErrorResume"
                )));
    }
}
package com.bootcamp.personal.passive.fixedtermaccount.controlller;


import com.bootcamp.personal.passive.fixedtermaccount.entity.FixedTermAccount;
import com.bootcamp.personal.passive.fixedtermaccount.service.FixedTermAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("personal/passive/saving_account")
@Tag(name = "Personal Passive Product Saving Account Type", description = "Manage Personal Passive Product saving accounts type")
@CrossOrigin(value = {"*"})
@RequiredArgsConstructor
public class FixedTermAccountController {

    public final FixedTermAccountService service;

    @GetMapping//(value = "/fully")
    public Mono<ResponseEntity<Flux<FixedTermAccount>>> getAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getAll())
        );
    }

    @PostMapping
    public Mono<ResponseEntity<FixedTermAccount>> create(@RequestBody FixedTermAccount fixedTermAccount) {

        return service.save(fixedTermAccount).map(p -> ResponseEntity
                .created(URI.create("/FixedTermAccount/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p)
        );
    }

    @PutMapping
    public Mono<ResponseEntity<FixedTermAccount>> update(@RequestBody FixedTermAccount fixedTermAccount) {
        return service.update(fixedTermAccount)
                .map(p -> ResponseEntity.created(URI.create("/FixedTermAccount/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<FixedTermAccount>> delete(@RequestBody String id) {
        return service.delete(id)
                .map(p -> ResponseEntity.created(URI.create("/FixedTermAccount/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

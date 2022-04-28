package com.bootcamp.personal.passive.fixedtermaccount.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.personal.passive.fixedtermaccount.entity.PersonalPassiveFixedTermAccountMovement;
import com.bootcamp.personal.passive.fixedtermaccount.service.PersonalPassiveFixedTermAccountMovementServiceImpl;

@RestController
@RequestMapping("enterprise/passive/pyme_current_account")
@Tag(name = "Personal Passive Fixed Term Account Movement Type", description = "Personal Passive Fixed Term Account Movement type")
@CrossOrigin( value = { "*" })
@RequiredArgsConstructor
public class PersonalPassiveFixedTermAccountMovementController {
	
	@Autowired
    public final PersonalPassiveFixedTermAccountMovementServiceImpl service;

    @GetMapping
    public Flux<PersonalPassiveFixedTermAccountMovement> getAll() {
        return service.findAll();
    }
    
    @GetMapping("/find/{num}")
    public Flux<PersonalPassiveFixedTermAccountMovement> findByNum(@PathVariable String num){
    	return service.findByDocumentNumber(num);
    }
    
    @PostMapping
    public Mono<PersonalPassiveFixedTermAccountMovement> create(@RequestBody PersonalPassiveFixedTermAccountMovement p) {
        return service.create(p);
    }

    @PutMapping("/update/{id}")
    public Mono<PersonalPassiveFixedTermAccountMovement> update(@RequestBody PersonalPassiveFixedTermAccountMovement p, @PathVariable String id) {
        return service.update(p);
    }
    
    @DeleteMapping("/deleteById/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteById(id);
    }

}
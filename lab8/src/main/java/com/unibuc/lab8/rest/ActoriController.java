package com.unibuc.lab8.rest;


import com.unibuc.lab8.dto.ActorDTO;
import com.unibuc.lab8.service.ActorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "actori")
public class ActoriController {
        @Autowired
        private ActorServices actoriServices;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<ActorDTO> get(@PathVariable Long id) {
        return new ResponseEntity<>(actoriServices.getById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<ActorDTO> getAll(){
            return actoriServices.getAll();
        }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActorDTO> create(@Valid @RequestBody ActorDTO actorDTO) {
        return new ResponseEntity<>(
                actoriServices.create(actorDTO),
                HttpStatus.CREATED
        );
    }

        @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ActorDTO> update(@RequestBody @Valid ActorDTO request){
            return new ResponseEntity<>(actoriServices.update(request), actoriServices.update(request) != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
        }

        @DeleteMapping(path = "/delete/{id}")
        public String delete(@PathVariable Long id){
            return actoriServices.delete(id);
        }
    }

package com.unibuc.lab8.repository;

import com.unibuc.lab8.domain.Actor;
import com.unibuc.lab8.domain.Film;
import com.unibuc.lab8.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepository {

    private final List<Actor> ActoriList = new ArrayList<>();



    public Actor get(Long id) {
        return ActoriList.stream()
                .filter(actor -> actor.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException(String.format("Autorul cu cnp %d nu exista", id)));
    }

    public List<Actor> getAll() {
        return ActoriList;
    }

    public Actor save(Actor request) {
        ActoriList.add(request);
        return request;
    }

    public String delete(Long id) {
        Optional<Actor> actoriOptional = Optional.ofNullable(get(id));
        if (actoriOptional.isPresent()) {
            ActoriList.remove(actoriOptional.get());
            return "Removed!";
        }
        return "Nu exista Actorul cu id-ul " + id;
    }

    public Actor update(Actor request) {
        Optional<Actor> actoriOptional = Optional.ofNullable(get(request.getId()));
        if (actoriOptional.isPresent()) {
            ActoriList.remove(actoriOptional.get());
            ActoriList.add(request);
          return get(request.getId());
        }
        return null;
    }
    @PostConstruct
    private void initPersonList() {
        ActoriList.add(Actor.builder()
                .id(1L)
                .nume("A1")
                .prenume("A11")
                .varsta(125)
                .build());

        ActoriList.add(Actor.builder()
                .id(2L)
                .nume("A2")
                .prenume("A22")
                .varsta(125)
                .build());
        ActoriList.add(Actor.builder()
                .id(3L)
                .nume("A3")
                .prenume("A33")
                .varsta(125)
                .filmeList(Collections.singletonList(Film.builder()
                        .id(1L)
                        .nume_film("F1")
                        .durata(125)
                        .lansare(2020)
                        .gen("SF")
                        .build()))
                .build());
    }
}

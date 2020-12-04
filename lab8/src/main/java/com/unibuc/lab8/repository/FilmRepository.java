package com.unibuc.lab8.repository;

import com.unibuc.lab8.domain.Actor;
import com.unibuc.lab8.domain.Film;
import com.unibuc.lab8.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FilmRepository {

     private final List<Film> filmeList = new ArrayList<>();

    public FilmRepository() {
        initPersonList();
    }


    public Film get(Long id) {
        return filmeList.stream()
                .filter(actor -> actor.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException(String.format("Filmul cu id-ul %d nu exista", id)));
    }
    public List<Film> getAll() {
        return filmeList;
    }

    public Film save(Film request) {
        filmeList.add(request);
        return request;
    }

    public String delete(Long id) {
        Optional<Film> filmeOptional = Optional.ofNullable(get(id));
        if (filmeOptional.isPresent()) {
            filmeList.remove(filmeOptional.get());
            return "Removed!";
        }
        return "Person not person!";

    }

    public Film update(Film request) {
        Optional<Film> filmeOptional = Optional.ofNullable(get(request.getId()));
        if (filmeOptional.isPresent()) {
            filmeList.remove(filmeOptional.get());
            filmeList.add(request);
            return get(request.getId());
        }
        return null;
    }

    private void initPersonList() {
        filmeList.add(Film.builder()
                .id(1L)
                .nume_film("F1")
                .durata(125)
                .lansare(2020)
                .gen("SF")
                .build());

        filmeList.add(Film.builder()
                .id(2L)
                .nume_film("F2")
                .durata(125)
                .lansare(2022)
                .gen("actiune")
                .build());
        filmeList.add(Film.builder()
                .id(3L)
                .nume_film("F3")
                .durata(125)
                .lansare(2921)
                .gen("drama")
                .build());
    }
}

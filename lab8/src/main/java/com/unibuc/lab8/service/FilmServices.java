package com.unibuc.lab8.service;

import com.unibuc.lab8.domain.Film;
import com.unibuc.lab8.dto.FilmDTO;
import com.unibuc.lab8.exceptions.BadRequestException;
import com.unibuc.lab8.mapper.FilmMapper;
import com.unibuc.lab8.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class FilmServices {
    @Autowired
    private FilmRepository filmeRepository;
    @Autowired
    private FilmMapper filmeMapper;




    public FilmDTO getById(Long id){
        return filmeMapper.toDto(filmeRepository.get(id));
    }

    public List<FilmDTO> getAll(){
        return filmeRepository.getAll().stream()
                .map(filme -> filmeMapper.toDto(filme))
                .collect(Collectors.toList());
    }

    public FilmDTO create(FilmDTO request){
        validateRequest(request);
        Film saveFilm = filmeRepository.save(filmeMapper.toEntity(request));
        return filmeMapper.toDto(saveFilm);
    }

    public FilmDTO update(FilmDTO request){
        Film updateFilme = filmeRepository.update(filmeMapper.toEntity(request));
        if(updateFilme != null){
            return filmeMapper.toDto(updateFilme);
        }
        return null;
    }

    public String delete(Long id){
        return filmeRepository.delete(id);
    }
    private void validateRequest(FilmDTO request) {
        if (filmeRepository.getAll().stream()
                .anyMatch(film -> film.getId().equals(request.getId()))) {
            throw new BadRequestException("Acelasi ID");
        }
        if (filmeRepository.getAll().stream()
                .anyMatch(film -> film.getNume_film().equals(request.getNumefilm()))) {
            throw new BadRequestException("Acelasi numeFilm");
        }
    }
}

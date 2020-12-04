package com.unibuc.lab8.rest;

import com.unibuc.lab8.dto.FilmDTO;
import com.unibuc.lab8.service.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "film")
public class FilmeController {
    private final FilmServices filmeServices;

    @Autowired
    public FilmeController(FilmServices filmeServices) {
        this.filmeServices = filmeServices;
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> get(@PathVariable Long id) {
        return new ResponseEntity<>(filmeServices.getById(id), HttpStatus.OK);
    }
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmDTO> getAll(){
        return filmeServices.getAll();
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO) {
        return new ResponseEntity<>(
                filmeServices.create(filmDTO),
                HttpStatus.CREATED
        );
    }
    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> update(@RequestBody @Valid FilmDTO request){
        return new ResponseEntity<>(filmeServices.update(request), filmeServices.update(request) != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable Long id){
        return filmeServices.delete(id);
    }


}

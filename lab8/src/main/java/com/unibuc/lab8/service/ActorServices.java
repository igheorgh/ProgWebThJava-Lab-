package com.unibuc.lab8.service;

import com.unibuc.lab8.domain.Actor;
import com.unibuc.lab8.dto.ActorDTO;
import com.unibuc.lab8.exceptions.BadRequestException;
import com.unibuc.lab8.mapper.ActorMapper;
import com.unibuc.lab8.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServices {
    @Autowired
    private ActorRepository actoriRepository;
    @Autowired
    private ActorMapper actoriMapper;

    public ActorDTO getById(Long id){
        return actoriMapper.toDto(actoriRepository.get(id));
    }

    public List<ActorDTO> getAll() {
        return actoriMapper.toDto(actoriRepository.getAll());
    }

    public ActorDTO create(ActorDTO request){
        validateRequest(request);
        Actor savedActori = actoriRepository.save(actoriMapper.toEntity(request));
        return actoriMapper.toDto(savedActori);
    }

    public ActorDTO update(ActorDTO request){
        Actor updateActor = actoriRepository.update(actoriMapper.toEntity(request));
        if(updateActor != null){
            return actoriMapper.toDto(updateActor);
        }
        return null;
    }

    public String delete(Long id){
        return actoriRepository.delete(id);
    }
    private void validateRequest(ActorDTO request) {
        if (actoriRepository.getAll().stream()
                .anyMatch(film -> film.getId().equals(request.getActor_cnp()))) {
            throw new BadRequestException("Acelasi ID");
        }
        if (actoriRepository.getAll().stream()
                .anyMatch(film -> film.getNume().equals(request.getNumeActor()) && film.getPrenume().equals(request.getPrenumeActor()))) {
            throw new BadRequestException("Acelasi Nume Actor");
        }
    }
}

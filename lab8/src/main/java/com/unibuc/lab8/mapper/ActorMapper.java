package com.unibuc.lab8.mapper;

import com.unibuc.lab8.domain.Actor;
import com.unibuc.lab8.dto.ActorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring", uses = FilmMapper.class)
public interface ActorMapper extends EntityMapper<ActorDTO, Actor>  {
    @Mappings({
            @Mapping(target = "actor_cnp", source = "entity.id"),
            @Mapping(target = "numeActor", source = "entity.nume"),
            @Mapping(target = "prenumeActor", source = "entity.prenume"),
            @Mapping(target = "varstaActor", source = "entity.varsta"),
    })
    ActorDTO toDto(Actor entity);


    @Mappings({
            @Mapping(target = "id", source = "dto.actor_cnp"),
            @Mapping(target = "nume", source = "dto.numeActor"),
            @Mapping(target = "prenume", source = "dto.prenumeActor"),
            @Mapping(target = "varsta", source = "dto.varstaActor"),
    })
    Actor toEntity(ActorDTO dto);

}

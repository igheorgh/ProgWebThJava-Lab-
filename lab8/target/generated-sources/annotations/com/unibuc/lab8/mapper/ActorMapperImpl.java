package com.unibuc.lab8.mapper;

import com.unibuc.lab8.domain.Actor;
import com.unibuc.lab8.dto.ActorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-04T17:28:10+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class ActorMapperImpl implements ActorMapper {

    @Override
    public List<Actor> toEntity(List<ActorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Actor> list = new ArrayList<Actor>( dtoList.size() );
        for ( ActorDTO actorDTO : dtoList ) {
            list.add( toEntity( actorDTO ) );
        }

        return list;
    }

    @Override
    public List<ActorDTO> toDto(List<Actor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ActorDTO> list = new ArrayList<ActorDTO>( entityList.size() );
        for ( Actor actor : entityList ) {
            list.add( toDto( actor ) );
        }

        return list;
    }

    @Override
    public ActorDTO toDto(Actor entity) {
        if ( entity == null ) {
            return null;
        }

        ActorDTO actorDTO = new ActorDTO();

        actorDTO.setActor_cnp( entity.getId() );
        actorDTO.setNumeActor( entity.getNume() );
        actorDTO.setPrenumeActor( entity.getPrenume() );
        actorDTO.setVarstaActor( entity.getVarsta() );

        return actorDTO;
    }

    @Override
    public Actor toEntity(ActorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setVarsta( dto.getVarstaActor() );
        actor.setId( dto.getActor_cnp() );
        actor.setNume( dto.getNumeActor() );
        actor.setPrenume( dto.getPrenumeActor() );

        return actor;
    }
}

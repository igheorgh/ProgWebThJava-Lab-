package com.unibuc.lab8.mapper;

import com.unibuc.lab8.domain.Film;
import com.unibuc.lab8.dto.FilmDTO;
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
public class FilmMapperImpl implements FilmMapper {

    @Override
    public List<Film> toEntity(List<FilmDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Film> list = new ArrayList<Film>( dtoList.size() );
        for ( FilmDTO filmDTO : dtoList ) {
            list.add( toEntity( filmDTO ) );
        }

        return list;
    }

    @Override
    public List<FilmDTO> toDto(List<Film> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FilmDTO> list = new ArrayList<FilmDTO>( entityList.size() );
        for ( Film film : entityList ) {
            list.add( toDto( film ) );
        }

        return list;
    }

    @Override
    public FilmDTO toDto(Film entity) {
        if ( entity == null ) {
            return null;
        }

        FilmDTO filmDTO = new FilmDTO();

        filmDTO.setNumefilm( entity.getNume_film() );
        filmDTO.setDuratafilm( entity.getDurata() );
        filmDTO.setLansare_film( entity.getLansare() );
        filmDTO.setGen_film( entity.getGen() );
        filmDTO.setId( entity.getId() );

        return filmDTO;
    }

    @Override
    public Film toEntity(FilmDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Film film = new Film();

        film.setLansare( dto.getLansare_film() );
        film.setNume_film( dto.getNumefilm() );
        film.setGen( dto.getGen_film() );
        film.setDurata( dto.getDuratafilm() );
        film.setId( dto.getId() );

        return film;
    }
}

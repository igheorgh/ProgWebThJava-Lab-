package com.unibuc.lab8.mapper;

import com.unibuc.lab8.domain.Film;
import com.unibuc.lab8.dto.FilmDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FilmMapper extends EntityMapper<FilmDTO, Film> {
    @Mappings({
            @Mapping(target = "numefilm", source = "entity.nume_film"),
            @Mapping(target = "duratafilm", source = "entity.durata"),
            @Mapping(target = "lansare_film", source = "entity.lansare"),
            @Mapping(target = "gen_film", source = "entity.gen"),
    })
    FilmDTO toDto(Film entity);


    @Mappings({
            @Mapping(target = "nume_film", source = "dto.numefilm"),
            @Mapping(target = "durata", source = "dto.duratafilm"),
            @Mapping(target = "lansare", source = "dto.lansare_film"),
            @Mapping(target = "gen", source = "dto.gen_film"),
    })
    Film toEntity(FilmDTO dto);
}

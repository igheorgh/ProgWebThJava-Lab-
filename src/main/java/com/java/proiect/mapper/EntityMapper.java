package com.java.proiect.mapper;

import java.util.List;

public interface EntityMapper<D,E> {
    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntityList(List<D> dtoLst);
    List<D> toDtoList(List<E> entityList);
}

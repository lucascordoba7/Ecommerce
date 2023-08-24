package com.lucas.ecommerce.service;

import com.lucas.ecommerce.dto.IdRequestData;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface GenericService<T> {

    List<T> findAll();

    Optional<T> findById(long id);

    T create(T model);

    void delete(long id);

    default List<T> getEntitiesByID(List<IdRequestData> ids) {
        return ids.stream()
                .map(dto -> findById(dto.getId()).orElseThrow(EntityNotFoundException::new))
                .filter(Objects::nonNull)
                .toList();
    }
}
package com.lucas.hardwarestore.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T create(T t);
    void delete(long id);
}

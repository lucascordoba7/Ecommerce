package com.lucas.hardwarestore.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    List<T> findAll();

    Optional<T> findById(long id);

    T create(T model);

    void delete(long id);
}
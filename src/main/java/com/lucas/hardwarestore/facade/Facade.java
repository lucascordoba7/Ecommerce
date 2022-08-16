package com.lucas.hardwarestore.facade;

import java.util.List;
import java.util.Optional;

public interface Facade<T, D> {

    List<D> findAll();

    Optional<D> findById(long id);

    D create(T request);

    void delete(long id);
}

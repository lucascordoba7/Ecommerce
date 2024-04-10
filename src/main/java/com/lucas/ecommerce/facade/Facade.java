package com.lucas.ecommerce.facade;

import java.util.List;
import java.util.Optional;

public interface Facade<T, D> {

    List<D> findAll();

    Optional<D> findById(long id);

    D create(T request);

    D update(long id, T request);

    void delete(long id);
}

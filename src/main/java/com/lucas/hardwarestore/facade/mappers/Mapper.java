package com.lucas.hardwarestore.facade.mappers;

import java.util.List;

public interface Mapper<S, T> {

    T mapFrom(S source);

    default List<T> mapAllFrom(List<S> sources) {
        return sources.stream().map(this::mapFrom).toList();
    }
}
package com.lucas.ecommerce.facade.mappers;

import java.util.List;

public interface Mapper<S, T> {

    T mapFrom(S source);

    default List<T> mapAllFrom(List<S> sources) {
        if (sources == null || sources.isEmpty()){
            return null;
        }
        return sources.stream().map(this::mapFrom).toList();
    }
}
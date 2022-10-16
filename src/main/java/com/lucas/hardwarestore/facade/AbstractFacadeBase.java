package com.lucas.hardwarestore.facade;

import com.lucas.hardwarestore.facade.mappers.Mapper;
import com.lucas.hardwarestore.service.GenericService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractFacadeBase<RequestType, ResponseType, ModelType>
        implements Facade<RequestType, ResponseType> {

    private final GenericService<ModelType> service;
    private final Mapper<RequestType, ModelType> requestMapper;
    private final Mapper<ModelType, ResponseType> responseMapper;

    @Override
    public List<ResponseType> findAll() {
        return responseMapper.mapAllFrom(service.findAll());
    }

    @Override
    public Optional<ResponseType> findById(long id) {
        var model = service.findById(id);
        if (model.isEmpty())
            return Optional.empty();
        return Optional.of(responseMapper.mapFrom(model.get()));
    }

    @Override
    public ResponseType create(RequestType request) {
        return responseMapper
                .mapFrom(
                        service.create(
                                requestMapper.mapFrom(request)
                        )
                );
    }

    @Override
    public void delete(long id) {
        service.delete(id);
    }
}

package org.tk.spring.jpa3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Stock3CrudPagingService {

    private final Stock3CrudPagingRepository repository;

    public Stock3CrudPagingService(Stock3CrudPagingRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Stock3Entity> getAll() {
        return Streamable.of(repository.findAll()).stream().collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Stock3Entity> getAllSorted(Sort sort) {
        return Streamable.of(repository.findAll(sort)).stream().collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<Stock3Entity> getAllPaginated(@PageableDefault(size = 1) Pageable page) {
        return repository.findAll(page);
    }

    @Transactional
    public Stock3Entity save(Stock3Entity entity) {
        return repository.save(entity);
    }
}

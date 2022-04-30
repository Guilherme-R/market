package com.guilhermebrandao.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> findById(Long id);
    List<T> findAll();
    void insert (T t);
    void update (T t);
    void delete (Long id);
}

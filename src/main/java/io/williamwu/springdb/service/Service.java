package io.williamwu.springdb.service;

import java.util.List;

public interface Service<E> {

    List<E> getAll();

    E get(Integer id);

    int insert(E obj);

    int update(E obj);

    int delete(Integer id);

}
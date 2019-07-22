package io.williamwu.springdb.serviceschool.service;

import java.util.List;

public interface DBService<E> {

    List<E> getAll();

    List<E> get(E obj);

    int insert(E obj);

    int update(E obj);

    int delete(E obj);

}
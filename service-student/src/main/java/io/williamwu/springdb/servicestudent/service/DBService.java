package io.williamwu.springdb.servicestudent.service;

import java.util.List;

public interface DBService<E> {

    List<E> getAll();

    List<E> get(E obj);

    List<E> getBatch(List<Integer> obj);

    int insert(E obj);

    int update(E obj);

    int delete(E obj);

}
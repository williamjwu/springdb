package io.williamwu.springdb.service;

import java.util.List;

public interface Service<E> {

    List<E> get();

    List<E> get(String name);

    int add(E obj);

    int update(String a, String b, Integer c, String d);

    int rm(String name);

}

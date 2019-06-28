package io.williamwu.springdb;

import java.util.List;

public interface Service<E> {

    List<E> get();

    List<E> getSpec(String name);

    int add(E obj);

    int update(E obj);

    int rm(String name);

}

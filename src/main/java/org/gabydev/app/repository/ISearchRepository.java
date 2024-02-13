package org.gabydev.app.repository;

import java.util.List;

public interface ISearchRepository<T> {

    List<T> findAll();

    T getById(Integer id);

    List<T> findByDirector(String name);

    List<T> findByGenre(String genre);

}

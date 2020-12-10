package org.academiadecodigo.bitjs.whitelotus.powerpeople.dao;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);
}

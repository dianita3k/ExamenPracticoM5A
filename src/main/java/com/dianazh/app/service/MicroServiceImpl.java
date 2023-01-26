/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianazh.app.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LENOVO
 */
public abstract class MicroServiceImpl  <T, ID extends Serializable> implements MicroService<T, ID> {
     public abstract CrudRepository<T, ID> getDao();

    @Override
    public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(data -> list.add(data));
        return list;
    }

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T findById(ID id) {
        Optional<T> data = getDao().findById(id);
        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }
}

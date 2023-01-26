/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianazh.app.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface MicroService <T, ID extends Serializable> {
  public List<T> findByAll();

    public T save(T entity);

    public T findById(ID id);

    public void delete(ID id);  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianazh.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.dianazh.app.entity.Empleado;
import com.dianazh.app.reporitory.EmpleadoRepository;

/**
 *
 * @author LENOVO
 */
@Service 
public class EmpleadoServiceImpl extends MicroServiceImpl<Empleado, Integer> implements EmpleadoService {

    @Autowired
       private EmpleadoRepository empleadoRepository;
    
    @Override
    public CrudRepository<Empleado, Integer> getDao() {
       return empleadoRepository; 
    }
    
}

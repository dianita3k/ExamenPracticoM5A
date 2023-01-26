/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianazh.app.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianazh.app.entity.Empleado;

/**
 *
 * @author LENOVO
 */
public interface EmpleadoRepository extends JpaRepository<Empleado ,Integer> {
    
}

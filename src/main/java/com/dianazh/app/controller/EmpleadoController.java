/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianazh.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.dianazh.app.entity.Empleado;
import com.dianazh.app.service.EmpleadoService;
/**
 *
 * @author LENOVO
 */
@Service 
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
    private EmpleadoService empleados;

    @GetMapping("/e/listar")
    public ResponseEntity<List<Empleado>> getAll() {
        try {
            return new ResponseEntity<>(empleados.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/e/buscar/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(empleados.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/e/crear")
    public ResponseEntity<Empleado> createReproducion(@RequestBody Empleado em){
        try {
            return new ResponseEntity<>(empleados.save(em), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/e/eliminar/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            empleados.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al docente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/e/editar/{id}")
    public ResponseEntity<Empleado> updateClient(@RequestBody Empleado emp, @PathVariable("id") Integer id){
        Empleado em =empleados.findById(id);

        if(em == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                em.setApellido(emp.getApellido());
                em.setNombre(emp.getNombre());
                em.setTelefono(emp.getTelefono());
                em.setDireccion(emp.getDireccion());
                em.setFecha_nacimiento(emp.getFecha_nacimiento());
                em.setObservacion(emp.getObservacion());
                em.setDias_trabajo(emp.getDias_trabajo());
                em.setSueldo(emp.getSueldo());

                return new ResponseEntity<>(empleados.save(emp), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}

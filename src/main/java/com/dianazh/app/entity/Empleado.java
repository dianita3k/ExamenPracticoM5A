/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianazh.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LENOVO
 */
@Getter
@Setter
@Entity
@Table(name = "asignatura")
public class Empleado implements Serializable {
	private static final long serialVersionUID = -9069060843698080433L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Column(name = "apellido",length=45)
    private String apellido;

    @Column(name = "nombre",length=45)
    private String nombre;
    
     @Column(name = "telefono",length=15)
    private String telefono;

    @Column(name = "direccion",length=45)
    private String direccion;
    
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column(name = "observacion",length=45)
    private String observacion;
    
    @Column(name = "dias_trabajo",length=45)
    private int dias_trabajo;
     
    @Column(name = "sueldo",nullable=false)
    private float sueldo;
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="equipos")
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "no puede estar vacio")
    //@Column(nullable = false, length=30).
    private String nombre;
    
      
    //@JsonIgnoreProperties(value = {"sorteo", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "sorteo") //, cascade = CascadeType.ALL
    //private List<Venta> ventas;
    
    /*public Equipo() {
        this.ventas = ventas;
    }*/
    
    /*public Equipo(List<Venta> ventas) {
        this.ventas = ventas;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
}

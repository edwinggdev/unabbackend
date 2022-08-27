/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PartidoTemp {
    @Id
    private int id;
    
    /*@JsonIgnoreProperties(value={"sorteo", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    
    @JsonIgnoreProperties(value={"sorteo", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Sorteo sorteo; */
    
    private int usuario;
    private String local;
    private String visitante;
    

    private Date fecha;
    

    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int goles_local;
    

    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int goles_visitante;
    

    public PartidoTemp() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

  

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    
    
    
    
}

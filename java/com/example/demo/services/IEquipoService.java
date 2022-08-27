/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import java.awt.print.Pageable;
import java.util.List;
import com.example.demo.models.Equipo;
import org.springframework.data.domain.Page;

/**
 *
 * @author LENOVO
 */
public interface IEquipoService {
     public List<Equipo> findAll();

    public Page<Equipo> findAll(Pageable pageable);

    public Equipo findById(Long id);
    
    public Equipo findByIdImg(Long  id);

   // public void delete(Long id);
}

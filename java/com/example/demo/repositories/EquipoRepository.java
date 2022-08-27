/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
}

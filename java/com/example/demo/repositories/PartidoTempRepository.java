/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.models.PartidoTemp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO
 */
public interface PartidoTempRepository extends JpaRepository<PartidoTemp, Long> {
    
    
//    @Transactional(readOnly=true)
//    @Query(value="select count (id) from partidos where sorteo = ?1", nativeQuery = true)
//    public int findTodos(Integer sorteo_id);
    
    @Transactional(readOnly=true)
    @Query(value="select p.id, p.usuario, e.nombre local , e2.nombre visitante,  p.fecha , p.goles_local, p.goles_visitante from partidos p, equipos e, equipos e2 WHERE p.local = e.id AND p.visitante = e2.id", nativeQuery = true)
    public List<PartidoTemp> findTodos();
    
}

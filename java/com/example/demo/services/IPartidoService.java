/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.Partido;
import com.example.demo.models.PartidoTemp;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IPartidoService {
    public Partido save(Partido cliente);
   // public int findBoletoNumero(int sorteo_id);
    public List<Partido> findAll();
    public List<PartidoTemp> findTodos();
    public void findByPartidoActualizar(int partidoid,int goles_local, int goles_visitante);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import com.example.demo.models.Partido;
import com.example.demo.models.PartidoTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.PartidoRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.services.IPartidoService;

/**
 *
 * @author LENOVO
 */
@Service
public class PartidoServiceImpl implements IPartidoService {
    @Autowired
    private PartidoRepository partidoRepository;
        
    @Override
    public Partido save(Partido partido) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return partidoRepository.save(partido);
    }

//    @Override
//    public int findBoletoNumero(int sorteo_id) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return partidoRepository.findBoletoNumero(sorteo_id);
//    }

    @Override
    @Transactional(readOnly = true)
    public List<Partido> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (List<Partido>) partidoRepository.findAll();
    }

    @Override
    public void findByPartidoActualizar(int partidoid, int goles_local, int goles_visitante) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        partidoRepository.findByPartidoActualizar(partidoid, goles_local, goles_visitante); //findByNumeroBloquear(Integer.parseInt(id + ""), numero);
    }

    @Override
    public List<PartidoTemp> findTodos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return partidoRepository.findTodos();
    }
    
}

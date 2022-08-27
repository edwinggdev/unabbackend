/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import java.awt.print.Pageable;
import java.util.List;
import com.example.demo.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repositories.EquipoRepository;
import com.example.demo.services.IEquipoService;

/**
 *
 * @author LENOVO
 */
@Service
public class EquipoServiceImpl implements IEquipoService {
    @Autowired
    private EquipoRepository sorteoRepository;

     @Override
    @Transactional(readOnly = true)
    public List<Equipo> findAll() {
        return (List<Equipo>) sorteoRepository.findAll();
    }
    
    @Override
    public Page<Equipo> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public Equipo findById(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return sorteoRepository.findById(id).orElse(null);
    }

    @Override
    public Equipo findByIdImg(Long id) {
         return sorteoRepository.findById(id).orElse(null);
    }
    
}

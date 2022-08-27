/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;


import com.example.demo.models.PartidoTemp;
import com.example.demo.repositories.PartidoTempRepository;

import com.example.demo.services.IPartidoTempService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author LENOVO
 */
@Service
public class PartidoTempServiceImpl implements IPartidoTempService {
    
    @Autowired
    private PartidoTempRepository partidoRepository;
        

    @Override
    public List<PartidoTemp> findTodos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return partidoRepository.findTodos();
    }
    
}

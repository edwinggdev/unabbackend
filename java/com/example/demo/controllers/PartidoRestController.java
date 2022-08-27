/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.Partido;
import com.example.demo.models.PartidoTemp;
import com.example.demo.models.RespuestaTemp;

import com.example.demo.services.IUsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.services.IPartidoService;
import com.example.demo.services.IPartidoTempService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/partido")
public class PartidoRestController {
    @Autowired
    private IPartidoService partidoService;
    
    @Autowired
    private IPartidoTempService partidoTempService;
    
    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping("/hola")
     public String home(){
         return " Hola Usuario!";
     }
     
    //@GetMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    public List<PartidoTemp> list() {
        
        List<PartidoTemp> lista = new ArrayList<PartidoTemp>();
        lista = partidoTempService.findTodos();
        return lista;
    }
    
     
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(readOnly = false)
    //public ResponseEntity<?> create(@RequestBody RespuestaTemp  v) {
    public RespuestaTemp create(@RequestBody Partido p) {
        
        Partido partido = new Partido();
        RespuestaTemp v = new RespuestaTemp();

        try {
            partido = partidoService.save(p);
            v.setMensaje( "el partido ha sido registrado con éxito!");

        } catch (DataAccessException e) {

            v.setMensaje("Error: " + e.getMessage().concat(": ").concat(e.getMessage()));
            return v;
        }

        return v;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public RespuestaTemp update(@RequestBody Partido p) throws Exception{
        Map<String, Object> response = new HashMap<>();
        RespuestaTemp v = new RespuestaTemp();
        try {
            System.out.println("1" + p.getId());
             partidoService.findByPartidoActualizar((int) p.getId(), p.getGoles_local(), p.getGoles_visitante());
            //response.put("numeros", numeros);
            v.setMensaje( "el partido ha sido actualizado con éxito!");
         } catch (DataAccessException e) {
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            v.setMensaje("Error: " + e.getMessage().concat(": ").concat(e.getMessage()));
            return v;
        }
        //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        return v;
    }
}

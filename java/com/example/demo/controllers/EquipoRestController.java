/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.Imagen;
import java.util.List;
import com.example.demo.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.services.IEquipoService;
import org.springframework.web.bind.annotation.GetMapping;

//@CrossOrigin(origins = {"http://localhost:4200", "*"})
@CrossOrigin(origins = "/*")
@RestController
@RequestMapping("/equipo")
public class EquipoRestController {
    @Autowired
    private IEquipoService sorteoService;
    
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Equipo> list() {
        
        List<Equipo> lista = new ArrayList<Equipo>();
        lista = sorteoService.findAll();
        
       //return sorteoService.findAll();
        return lista;
        
    }
    
    
    
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
    public ResponseEntity<?> findById(@RequestParam(name = "id")  int sorteoId) throws Exception{

        Map<String, Object> response = new HashMap<>();
        Equipo sorteo;
        try {
            //model.addAttribute("titulo", "Buscar usuario");
            System.out.println("1" + sorteoId);
            sorteo = sorteoService.findById(Long.parseLong(sorteoId + ""));
            //model.addAttribute("usuarios", usuario);
            response.put("sorteo", sorteo);

        }catch(Exception e){
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return usuario;
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/equipos", method = RequestMethod.GET)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
    public List<Imagen> findByIdImg(@RequestParam(name = "id")  int sorteoId){

       // Map<String, Object> response = new HashMap<>();
        Equipo sorteo;
        String inicio = "http://192.168.197.1:9011/images/";
        String fin = ".jpg";
        List <Imagen> imagenes = new ArrayList<Imagen>();
        
            //model.addAttribute("titulo", "Buscar usuario"
         
            //imagenes.add("erewrer");
        //return usuario;
        return imagenes;
    }
}

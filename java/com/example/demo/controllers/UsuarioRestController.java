/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.RespuestaTemp;
import java.util.List;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.services.IUsuarioService;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    private IUsuarioService usuarioService;
    
    /*@GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> list() {
        return usuarioService.findAll();
    } */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> list() {
        
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "listado!");
        return usuarioService.findAll();
    }
    
    /*@GetMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAll(String cedula) {
        return usuarioService.findByCedula(cedula);
    }*/
    
    @RequestMapping(value = "/cedula", method = RequestMethod.GET)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
        public Usuario findByCedula(@RequestParam(name = "cedula")  String cedula) throws Exception{

   // public ResponseEntity<?> findByCedula(@RequestParam(name = "cedula")  String cedula) throws Exception{

        Map<String, Object> response = new HashMap<>();
        Usuario usuario = null;
        try {
            //model.addAttribute("titulo", "Buscar usuario");
            System.out.println("1" + cedula);
            usuario = usuarioService.findByCedula(cedula);
            
            //model.addAttribute("usuarios", usuario);
            //response.values(usuario);// .put("", usuario);
            response.put("id", usuario.getId() + "");
            response.put("cedula",usuario.getUsername());
            response.put("nombres",usuario.getNombre());
        }catch(Exception e){
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return usuario;
        //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        //return new ResponseEntity<Usuario>((Usuario) response, HttpStatus.CREATED);
    }
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(readOnly = false)
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        Usuario usuarioNew = null;
        Map<String, Object> response = new HashMap<>();
        try {
            //return ResponseEntity.status(HttpStatus.CREATED)
            //        .body(marcaService.save(marca));
            response.put("usuario", usuario);
            usuarioNew = usuarioService.save(usuario);
            response.put("mensaje", "El Usuario ha sido creado con éxito!");
        
        } catch (DataAccessException e) {
            //return ResponseEntity.notFound().build();
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
        public RespuestaTemp findByUsuario(@Param(value = "username") String username,@Param(value = "password") String password) throws Exception{

        Map<String, Object> response = new HashMap<>();
        RespuestaTemp respuesta = new RespuestaTemp();
        Usuario usuario;
        try {
            //model.addAttribute("titulo", "Buscar usuario");
            System.out.println("intenta ingresar: " + username);
            usuario = usuarioService.findByDatos(username, password);

            if(!usuario.getNombre().equals("")){
                System.out.println("localizado: " + usuario.getNombre());
                System.out.println(" acceso concedido!");
//                String key = "mi llave";
//                long tiempo = System.currentTimeMillis();
//                String jwt = Jwts.builder()
//                        .signWith(SignatureAlgorithm.HS256, key)
//                        .setSubject("Bienvenido")
//                        .setIssuedAt(new Date(tiempo))
//                        .compact();
//                respuesta.setMensaje(jwt);
            }
            if(usuario == null){
                System.out.println(" acceso Denegado!");
                
                respuesta.setMensaje("datos de acceso erroneo");
            }
            //model.addAttribute("usuarios", usuario);
            //response.values(usuario);// .put("", usuario);
//            response.put("id", usuario.getId() + "");
//            response.put("cedula",usuario.getUsername());
//            response.put("nombres",usuario.getNombre());
        }catch(Exception e){
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
        //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        //return new ResponseEntity<Usuario>((Usuario) response, HttpStatus.CREATED);
    }
}

package org.bedu.crm_java.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.bedu.crm_java.model.Producto1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {


    @GetMapping
    public ResponseEntity <List<Producto1>> getProductos(){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto1> getProducto(@PathVariable Long productoId){
        return ResponseEntity.ok(new Producto1());
    }

    @PostMapping
    public ResponseEntity<Void> creaProducto(@RequestBody Producto1 producto){
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<Void> actualizaProducto(@PathVariable Long productoId, @RequestBody Producto1 producto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminaProducto(@PathVariable Long productoId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } 
}

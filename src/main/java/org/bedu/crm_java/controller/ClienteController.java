package org.bedu.crm_java.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.bedu.crm_java.model.Cliente;
import org.bedu.crm_java.repositorys.ClienteRepository;
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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity <List<Cliente>> getClientes(){
        return ResponseEntity.ok(new ArrayList<>()) ;
    }
    
    @GetMapping("/{clienteid}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteid){
        return ResponseEntity.ok(new Cliente());
    }

    @PostMapping
    public ResponseEntity<Void> crearCliente(@RequestBody Cliente cliente){
        Cliente clienteDB = clienteRepository.save(cliente);

        return ResponseEntity.created(URI.create(clienteDB.getId().toString())).build();
        
    }

    @PutMapping("/{clienteid}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable Long clienteid, @RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build() ;
    }

    @DeleteMapping("/{clienteid}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long clienteid){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build() ;
    }


}

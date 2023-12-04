package org.bedu.crm_java.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.bedu.crm_java.model.Cliente;
import org.bedu.crm_java.services.ClienteService;
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
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity <List<Cliente>> getClientes(){
        return ResponseEntity.ok(clienteService.obtenerClientes()) ;
    }
    
    @GetMapping("/{clienteid}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteid){
        Optional<Cliente> clienteBd= clienteService.obtenerCliente(clienteid);
        if (clienteBd.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "El cliente especifícado no existe,")
                ;
        }
        return ResponseEntity.ok(clienteBd.get());
    }

    @PostMapping
    public ResponseEntity<Void> creaCliente(@Valid @RequestBody Cliente cliente){
        Cliente clienteNuevo = clienteService.guardarCliente(cliente) ;
        return ResponseEntity.created(URI.create(String.valueOf(clienteNuevo.getId()))).build();
    }

    @PutMapping("/{clienteid}")
    public ResponseEntity<Void> actualizarCliente(@PathVariable Long clienteid, @RequestBody @Valid Cliente cliente){
        clienteService.actualizarCliente(cliente);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build() ;
    }
    
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminaCliente(@PathVariable Long clienteId) {
        clienteService.eliminarCliente(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

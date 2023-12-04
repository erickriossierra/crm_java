package org.bedu.crm_java.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.bedu.crm_java.model.Etapa;
import org.bedu.crm_java.services.EtapaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/etapa")
@RequiredArgsConstructor
public class EtapaController {
 
    private final EtapaService etapaService;
    
    @GetMapping
    public ResponseEntity <List<Etapa>> getEtapas(@RequestParam Long clienteid){
        return ResponseEntity.ok(etapaService.obtenerClientes());
    }

    @GetMapping("/{etapaid}")
    public ResponseEntity<Etapa> getEtapa(@PathVariable Long etapaid){
        Optional<Etapa> etapaBd = etapaService.obtenerEtapa(etapaid);
        if (etapaBd.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La etapa no existe.");
        }
        return ResponseEntity.ok(etapaBd.get());
    }

    @PostMapping
    public ResponseEntity<Void> creaEtapa(@RequestBody Etapa etapa, @RequestParam Long clienteid){
        Etapa etapaNueva = etapaService.guardarEtapas(etapa) ;
        return ResponseEntity.created(URI.create(String.valueOf(etapaNueva.getId()))).build();
    }

    @PutMapping("/{etapaid}")
    public ResponseEntity<Void> actualizaEtapa(@PathVariable Long etapaid, @RequestBody Etapa etapa){
        etapaService.actualizarEtapa(etapa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{etapaid}")
    public ResponseEntity<Void> eliminaEtapa(@PathVariable Long etapaid){
        etapaService.eliminarEtapa(etapaid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

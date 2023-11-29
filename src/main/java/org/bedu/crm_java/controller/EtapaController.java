package org.bedu.crm_java.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.bedu.crm_java.model.Etapa;
import org.bedu.crm_java.repositorys.EtapaRepository;
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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/etapa")
@RequiredArgsConstructor
public class EtapaController {

    private final EtapaRepository etapaRepository;
    
    @GetMapping
    public ResponseEntity <List<Etapa>> getEtapas(@RequestParam Long clienteid){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{etapaid}")
    public ResponseEntity<Etapa> getEtapa(@PathVariable Long etapaid){
        return ResponseEntity.ok(new Etapa());
    }

    @PostMapping
    public ResponseEntity<Void> creaEtapa(@RequestBody Etapa etapa, @RequestParam Long clienteid){
        Etapa etapaBD = etapaRepository.save(etapa);
        return ResponseEntity.created(URI.create(etapaBD.getEtapaId().toString())).build();
    }

    @PutMapping("/{etapaid}")
    public ResponseEntity<Void> actualizaEtapa(@PathVariable Long etapaid, @RequestBody Etapa etapa){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{etapaid}")
    public ResponseEntity<Void> eliminaEtapa(@PathVariable Long etapaid){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

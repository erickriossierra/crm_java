package org.bedu.crm_java.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bedu.crm_java.controller.mappers.VisitaMapper;
import org.bedu.crm_java.model.Visita;
import org.bedu.crm_java.persistence.repositorys.VisitaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VistaService {

    private final VisitaRepository visitaRepository;
    private final VisitaMapper visitaMapper;

    public List<Visita> obtenerVisitas(){
        return visitaRepository
        .findAll()
        .stream()
        .map(visita -> visitaMapper
            .visitaEntityToVisitModel(visita)).collect(Collectors.toList()) ;
    }

    public Optional<Visita> obtenerVisita(Long visita){
        return visitaRepository.findById(visita)
        .map(Visita -> Optional.of(visitaMapper.visitaEntityToVisitModel(Visita)))
        .orElse(Optional.empty())
        ;
    }

    public Visita guardarVisita(Visita visita){
        return visitaMapper
        .visitaEntityToVisitModel(visitaRepository
            .save(visitaMapper.visitaModelToVisitaEntity(visita)))
        
         ;
    }

    public Visita actualizarVisita(Visita visita){
        return visitaMapper.visitaEntityToVisitModel(
            visitaRepository.save(visitaMapper.visitaModelToVisitaEntity(visita))
        )
        ;
    }

    public void eliminarVisita(Long vistaId){
        visitaRepository.deleteById(vistaId);
    }

    public Long cuentaVisitas(){return visitaRepository.count();}
}

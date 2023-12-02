package org.bedu.crm_java.services;

import org.bedu.crm_java.controller.mappers.EtapaMapper;
import org.bedu.crm_java.model.Etapa;
import org.bedu.crm_java.persistence.repositorys.EtapaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtapaService {
    private final EtapaRepository etapaRepository;
    private final EtapaMapper etapaMapper;

    public Etapa guardarEtapas(Etapa etapa){
        return etapaMapper
        .etapaEntityToEtapaModel(etapaRepository
            .save(etapaMapper
                .etapaModelToEtapaEntity(etapa)))
        ;
    }

    public List<Etapa> obtenerClientes(){
        return etapaRepository
        .findAll()
        .stream()
        .map(etapa -> etapaMapper.etapaEntityToEtapaModel(etapa))
        .collect(Collectors.toList())
        ; 

    }

    public Optional<Etapa> obtenerEtapa(Long etapaid){
        return etapaRepository.findById(etapaid)
        .map(Etapa -> Optional.of(etapaMapper.etapaEntityToEtapaModel(Etapa)))
        .orElse(Optional.empty())
        ;
    }

    public void eliminarEtapa (Long etapaid){
        etapaRepository.deleteById(etapaid);;
    }

    public Etapa actualizarEtapa(Etapa etapa){
        return etapaMapper
        .etapaEntityToEtapaModel(
            etapaRepository.save(
                etapaMapper.etapaModelToEtapaEntity(etapa)))
        ;
    }

    public Long contadorEtapa(){
        return etapaRepository.count();
    }
    

}

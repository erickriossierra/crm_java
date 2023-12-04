package org.bedu.crm_java.services;

import org.bedu.crm_java.controller.mappers.VentaMapper;
import org.bedu.crm_java.model.Venta;
import org.bedu.crm_java.persistence.repositorys.VentaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class VentasService {
    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;

    public Venta guardarVenta(Venta venta){
        return ventaMapper
        .ventaEntityToVentaModel(
            ventaRepository
            .save(ventaMapper
                .ventaModelToVentaEntity(venta)))
        ;
    }
    
    public List<Venta> obtenerVentas(){
        return ventaRepository.findAll()
        .stream()
        .map(venta -> ventaMapper.ventaEntityToVentaModel(venta))
        .collect(Collectors.toList())
        ;
    }

    public Optional<Venta> obtenerVenta(Long ventaid){
        return ventaRepository.findById(ventaid)
        .map(venta -> Optional.of(ventaMapper.ventaEntityToVentaModel(venta)))
        .orElse(Optional.empty())
        ;
    }

    public void borrarVenta(Long ventaid){
        ventaRepository.deleteById(ventaid);
    }

    public Venta actualziarVenta (Venta venta){
        return ventaMapper.ventaEntityToVentaModel(
            ventaRepository.save(ventaMapper.ventaModelToVentaEntity(venta))
        );
    }

    public Long contarVenta(){
        return ventaRepository.count();
    }

}
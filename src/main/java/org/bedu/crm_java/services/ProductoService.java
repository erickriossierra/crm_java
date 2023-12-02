package org.bedu.crm_java.services;

import org.bedu.crm_java.controller.mappers.ProductoMapper;
import org.bedu.crm_java.model.Producto;
import org.bedu.crm_java.persistence.repositorys.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    public Producto guardarProducto(Producto producto){
        return productoMapper.productoEntityToProductoModel(
            productoRepository.save(productoMapper.productoModelToProductoEntity(producto)))
        ; 
    }

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll()
        .stream()
        .map(producto -> productoMapper.productoEntityToProductoModel(producto))
        .collect(Collectors.toList())
        ;
    }

    public Optional<Producto> obtenerProducto(Long productoid){
        return productoRepository.findById(productoid)
        .map(producto -> Optional.of(productoMapper.productoEntityToProductoModel(producto)))
        .orElse(Optional.empty())
        ;
    }

    public void eliminarProducto(Long productoid){
        productoRepository.deleteById(productoid);
    }

    public Producto actualizarProducto(Producto producto){
        return productoMapper
        .productoEntityToProductoModel(
            productoRepository.save(
                productoMapper.productoModelToProductoEntity(producto)))
        ;
    }

    public Long contadorProducto(){
        return productoRepository.count();
    }
    
}

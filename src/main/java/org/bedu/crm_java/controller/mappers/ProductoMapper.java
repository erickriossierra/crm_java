package org.bedu.crm_java.controller.mappers;

import org.bedu.crm_java.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.crm_java.model.Producto productoModel);
    org.bedu.crm_java.model.Producto productoEntityToProductoModel(Producto productoEntity);
    
    
}

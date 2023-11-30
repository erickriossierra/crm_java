package org.bedu.crm_java.controller.mappers;

import org.bedu.crm_java.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.crm_java.model.Venta ventaModel);
    org.bedu.crm_java.model.Venta ventaEntityToVentaModel(Venta ventaEntity);
    
}

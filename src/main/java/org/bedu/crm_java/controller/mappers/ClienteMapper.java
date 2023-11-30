package org.bedu.crm_java.controller.mappers;


import org.bedu.crm_java.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
   Cliente clienteModelToClienteEntity(org.bedu.crm_java.model.Cliente clienteModel);
   org.bedu.crm_java.model.Cliente clienteEntityToClienteModel(Cliente clienteEntity);
   
}

package org.bedu.crm_java.controller.mappers;

import org.bedu.crm_java.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity (Cliente clienteModel);
    Cliente clienteEntityToClienteModel(Cliente cliente);
    
}

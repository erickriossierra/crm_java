package org.bedu.crm_java.controller.mappers;

import org.bedu.crm_java.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.crm_java.model.Visita visitaModel);
    org.bedu.crm_java.model.Visita visitaEntityToVisitModel(Visita visitaEntity);
    
}

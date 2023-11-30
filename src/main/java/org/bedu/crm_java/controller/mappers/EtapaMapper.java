package org.bedu.crm_java.controller.mappers;

import org.bedu.crm_java.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaModelToEtapaEntity(org.bedu.crm_java.model.Etapa etapaModel);
    org.bedu.crm_java.model.Etapa etapaEntityToEtapaModel(Etapa etapaEntity);

}

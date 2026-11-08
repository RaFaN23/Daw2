package es.safareyes.parkingapp.converter;

import es.safareyes.parkingapp.Modelos.Tickets;
import es.safareyes.parkingapp.dtos.importeTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImporteTicketsMapper {

    importeTicket toDTO(Tickets entity);

    @Mapping(target = "plaza", ignore = true)
    @Mapping(target = "tarifa", ignore = true)
    @Mapping(target = "abonado", ignore = true)
    @Mapping(target = "promocion", ignore = true)
    Tickets toEntity(importeTicket dto);

    List<importeTicket> toDTO(List<Tickets> listEntity);

    List<Tickets> toEntity(List<importeTicket> listDTOs);
}
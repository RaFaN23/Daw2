package es.safareyes.parkingapp.converter;

import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface tarifaVigorMapper {
    tarifasVigentes toDTO(Tarifa entity);

    @Mapping(target = "tickets", ignore = true)
    Tarifa toEntity(tarifasVigentes dto);

    List<tarifasVigentes> toDTO(List<Tarifa> listEntity);

    List<Tarifa> toEntity(List<tarifasVigentes> listDTOs);

}

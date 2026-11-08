package es.safareyes.parkingapp.converter;

import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.dtos.PlazaDTO;
import es.safareyes.parkingapp.dtos.plazasLibres;
import org.mapstruct.Mapping;

import java.util.List;

public interface plazaLibresMapper {
    plazasLibres toDTO( Plaza entity);
    @Mapping(target = "tickets", ignore = true)
    Plaza toEntity(plazasLibres dto);

    List<plazasLibres> toDTO(List<Plaza> listEntity);

    List<Plaza> toEntity(List<plazasLibres> listDTOs);
}

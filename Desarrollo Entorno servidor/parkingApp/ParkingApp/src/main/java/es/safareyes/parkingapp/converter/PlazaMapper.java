package es.safareyes.parkingapp.converter;

import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.dtos.PlazaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlazaMapper {


    PlazaDTO toDTO(Plaza entity);

    @Mapping(target = "tickets", ignore = true)
    Plaza toEntity(PlazaDTO dto);

    List<PlazaDTO> toDTO(List<Plaza> listEntity);

    List<Plaza> toEntity(List<PlazaDTO> listDTOs);



}

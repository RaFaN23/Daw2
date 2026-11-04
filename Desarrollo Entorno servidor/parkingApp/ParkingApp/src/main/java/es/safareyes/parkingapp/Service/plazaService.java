package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Repositorio.PlazaRepositorio;
import es.safareyes.parkingapp.converter.PlazaMapper;
import es.safareyes.parkingapp.dtos.PlazaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class plazaService {

    @Autowired
    private PlazaRepositorio plazaRepositorio;

    @Autowired
    private PlazaMapper plazaMapper;



    public Page<PlazaDTO> listar(Integer planta, String tipo, String estado, Pageable pageable) {
        return plazaRepositorio.buscarPlazasFiltradas(planta, tipo, estado, pageable)
                .map(plaza -> plazaMapper.toDTO(plaza));
    }

}

package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Repositorio.PlazaRepositorio;
import es.safareyes.parkingapp.converter.PlazaMapper;
import es.safareyes.parkingapp.converter.plazaLibresMapper;
import es.safareyes.parkingapp.dtos.PlazaDTO;
import es.safareyes.parkingapp.dtos.ocupacionPlanta;
import es.safareyes.parkingapp.dtos.plazasLibres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class plazaService {

    @Autowired
    private PlazaRepositorio plazaRepositorio;

    @Autowired
    private PlazaMapper plazaMapper;


    // Obtener todas las plazas con filtros
    public Page<PlazaDTO> listar(Integer planta, String tipo, String estado, Pageable pageable) {
        return plazaRepositorio.buscarPlazasFiltradas(planta, tipo, estado, pageable)
                .map(plaza -> plazaMapper.toDTO(plaza));
    }


    // Obtener todas las plazas libres por planta y tipo
    public List<plazasLibres> listarLibres(Integer planta, String tipo) {
        return plazaRepositorio.plazasLibresPorPlantas(planta, tipo);
    }


    //Ocupacion planta
    public List<ocupacionPlanta> ocupacionPlanta() {
        return plazaRepositorio.ocupacionPorPlanta();
    }
}

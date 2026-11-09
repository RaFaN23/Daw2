package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Modelos.Promocion;
import es.safareyes.parkingapp.Repositorio.PromocionRepositorio;
import es.safareyes.parkingapp.dtos.promocionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class promocionesService {
    @Autowired
    private PromocionRepositorio promocionesRepository;

    //Catalogo de promociones
    public List<promocionesDTO> catalogoPromociones() {
        return promocionesRepository.catalogoPromociones();
    }
}

package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Modelos.Usuarios;
import es.safareyes.parkingapp.Repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    @Transactional(readOnly = true)
    public List<Usuarios> buscarPorContrasenya(String contrasenya) {
        return usuarioRepositorio.buscarPorContrasenya(contrasenya);
    }
}
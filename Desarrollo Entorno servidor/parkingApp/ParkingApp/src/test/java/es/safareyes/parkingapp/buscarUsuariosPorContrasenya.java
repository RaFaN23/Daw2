package es.safareyes.parkingapp;

import es.safareyes.parkingapp.Modelos.Usuarios;
import es.safareyes.parkingapp.Service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class buscarUsuariosPorContrasenya {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void buscarUsuariosPorContrasenya() {

        List<Usuarios> usuarios =
                usuarioService.buscarPorContrasenya("clave1");

        System.out.println("Usuarios encontrados: " + usuarios.size());

        for (Usuarios usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Contraseña: " + usuario.getContrasenya());
        }
    }
}
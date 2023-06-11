package unaerp.estagios.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unaerp.estagios.api.usuarios.UsuarioRepository;

@RestController
@RequestMapping("login")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

}

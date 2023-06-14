package unaerp.estagios.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unaerp.estagios.api.usuarios.*;

import java.util.Optional;

@RestController
@RequestMapping("login")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid DadosCadastroUsuario dados) {
        Usuario usuario = usuarioRepository.findByEmail(dados.email());
        if (usuario == null ) {
            usuarioRepository.save(new Usuario(dados));
        } else {
            throw new RuntimeException("Esse e-mail já foi cadastrado");
        }
    }

    @PutMapping("{id}")
    @Transactional
    public void atualizar (@PathVariable Long id, @RequestBody DadosAtualizacaoUsuario dados) {
       Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
       if (usuarioOptional.isPresent()){
           Usuario usuario = usuarioOptional.get();
           usuario.atualizarInformacoes(dados);
       } else {
           throw new RuntimeException("Usuario não encontrado com o ID: " + id);
       }
    }

    @GetMapping("{id}")
    public DadosListagemUsuario listagem(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return new DadosListagemUsuario(usuario);
        }
        throw new RuntimeException("Usuário não cadastro com o ID: " + id);
    }


}

package unaerp.estagios.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unaerp.estagios.api.usuarios.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
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

    @PostMapping("/login")
    public DadosUsuario autenticar (@RequestBody DadosLoginUsuario dados){
        Usuario usuario = usuarioRepository.findByEmail(dados.email());

        if (usuario != null && usuario.getSenha().equals(dados.senha())){
               return new DadosUsuario(usuario);
        }

        throw new RuntimeException("Usuário ou senha incorreto");
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

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuarioRepository.delete(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

}

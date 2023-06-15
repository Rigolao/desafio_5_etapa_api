package unaerp.estagios.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import unaerp.estagios.api.anuncios.*;
import unaerp.estagios.api.usuarios.Usuario;
import unaerp.estagios.api.usuarios.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("vagas")
public class AnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAnuncio dados) {
        Anuncio anuncio = new Anuncio(dados);
        Usuario usuario = usuarioRepository.findById(dados.idUsuario()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        anuncio.setUsuario(usuario);

        anuncioRepository.save(anuncio);
    }

    @GetMapping
    public List<DadosListagemAnuncio> listar() {
        return anuncioRepository.findAll().stream().map(DadosListagemAnuncio::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DadosListagemAnuncio listar(@PathVariable Long id){
        Optional<Anuncio> anuncioOptional = anuncioRepository.findById(id);
        if (anuncioOptional.isPresent()) {
            Anuncio anuncio = anuncioOptional.get();
            return new DadosListagemAnuncio(anuncio);
        }
        throw new RuntimeException("Anúncio não encontrado com o ID: " + id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody DadosAtualizacaoAnuncio dados) {
        Optional<Anuncio> anuncioOptional = anuncioRepository.findById(id);
        if (anuncioOptional.isPresent()) {
            Anuncio anuncio = anuncioOptional.get();
            anuncio.atualizarInformacoes(dados);
        } else {
            throw new RuntimeException("Anúncio não encontrado com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Optional<Anuncio> anuncioOptional = anuncioRepository.findById(id);
        if (anuncioOptional.isPresent()) {
            Anuncio anuncio = anuncioOptional.get();
            anuncio.excluir();
        } else {
            throw new RuntimeException("Anúncio não encontrado com o ID: " + id);
        }
    }


}

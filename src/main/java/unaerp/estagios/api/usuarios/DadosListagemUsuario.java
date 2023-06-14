package unaerp.estagios.api.usuarios;

import unaerp.estagios.api.anuncios.Anuncio;
import unaerp.estagios.api.anuncios.DadosListagemAnuncio;

import java.util.ArrayList;
import java.util.List;

public record DadosListagemUsuario(
        Long id,
        String tipo,
        String nome,
        String email,
        List<DadosListagemAnuncio>anuncios
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getTipoUsuario() ? "USUARIO" : "ANUNCIANTE",usuario.getNome(), usuario.getEmail(), convertAnuncios(usuario.getAnuncios()));
    }

    private static List<DadosListagemAnuncio> convertAnuncios(List<Anuncio> anuncios) {
        List<DadosListagemAnuncio> anunciosListagem = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            DadosListagemAnuncio dadosListagemAnuncio = new DadosListagemAnuncio(anuncio);
            anunciosListagem.add(dadosListagemAnuncio);
        }
        return anunciosListagem;
    }
}


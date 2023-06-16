package unaerp.estagios.api.anuncios;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import unaerp.estagios.api.usuarios.DadosUsuario;

import java.util.Date;

public record DadosListagemAnuncio(
        Long id,
        String areaConhecimento,
        String descricao,
        String email,
        String telefone,
        @JsonFormat(pattern = "dd/MM/YYYY")
        @DateTimeFormat(pattern = "dd/MM/YYYY")
        Date dataInicio,
        @JsonFormat(pattern = "dd/MM/YYYY")
        @DateTimeFormat(pattern = "dd/MM/YYYY")
        Date dataFim,
        String localidade,
        String exibir,
        Integer status,
        Float remuneracao,
        DadosUsuario dadosUsuario) {
    public DadosListagemAnuncio(Anuncio anuncio) {
        this(anuncio.getId(), anuncio.getAreaConhecimento(), anuncio.getDescricao(), anuncio.getEmail(), anuncio.getTelefone(), anuncio.getDataInicio(), anuncio.getDataFim(), anuncio.getLocalidade(), anuncio.getExibir(), anuncio.getStatus(), anuncio.getRemuneracao(), new DadosUsuario(anuncio.getUsuario().getId(), anuncio.getUsuario().getNome(), anuncio.getUsuario().getSenha(), anuncio.getUsuario().getEmail(), anuncio.getUsuario().getTipoUsuario() ? 1 : 0));
    }
}

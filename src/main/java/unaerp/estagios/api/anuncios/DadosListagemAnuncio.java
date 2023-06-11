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
        DadosUsuario dadosUsuario) {
    public DadosListagemAnuncio(Anuncio anuncio) {
        this(anuncio.getId(), anuncio.getAreaConhecimento(), anuncio.getDescricao(), anuncio.getEmail(), anuncio.getTelefone(), anuncio.getDataInicio(), anuncio.getDataFim(), anuncio.getLocalidade(), new DadosUsuario(anuncio.getUsuario().getNome()));
    }
}

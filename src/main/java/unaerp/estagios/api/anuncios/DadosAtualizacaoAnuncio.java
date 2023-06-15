package unaerp.estagios.api.anuncios;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record DadosAtualizacaoAnuncio(
        String areaConhecimento,
        String descricao,
        String telefone,
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @DateTimeFormat(pattern = "dd/MM/YYYY")
        Date dataInicio,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @DateTimeFormat(pattern = "dd/MM/YYYY")
        Date dataFim,
        String exibir,
        String localidade) {
        public DadosAtualizacaoAnuncio {
                if (dataFim != null && dataInicio != null && dataFim.before(dataInicio)) {
                        throw new IllegalArgumentException("A data de término não pode ser anterior à data de início.");
                }
        }
}

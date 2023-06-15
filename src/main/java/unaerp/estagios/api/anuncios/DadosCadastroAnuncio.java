package unaerp.estagios.api.anuncios;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record DadosCadastroAnuncio(
        @NotNull
        Long idUsuario,
        @NotBlank
        String areaConhecimento,
        @NotBlank
        String descricao,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        @DateTimeFormat(pattern = "dd/MM/YYYY")
        Date dataInicio,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        @DateTimeFormat(pattern = "dd/MM/YYYY")
        Date dataFim,
        @NotNull
        String exibir,
        @NotBlank
        String localidade,
        Float remuneracao) {
    public DadosCadastroAnuncio {
        if (dataFim.before(dataInicio)) {
            throw new IllegalArgumentException("A data de término não pode ser anterior à data de início.");
        }
    }
}

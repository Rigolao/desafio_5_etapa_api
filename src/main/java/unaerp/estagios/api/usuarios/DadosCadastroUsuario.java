package unaerp.estagios.api.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(@NotBlank @Email String email,
                                   @NotBlank
                                   String nome,
                                   @NotNull
                                   Boolean tipo,
                                   @NotBlank
                                   String senha) {
}

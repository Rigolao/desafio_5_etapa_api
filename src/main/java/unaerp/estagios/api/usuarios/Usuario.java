package unaerp.estagios.api.usuarios;

import jakarta.persistence.*;
import lombok.*;
import unaerp.estagios.api.anuncios.Anuncio;
import unaerp.estagios.api.anuncios.DadosCadastroAnuncio;
import unaerp.estagios.api.tipoUsuario.TipoUsuario;

import java.util.List;

@Table(name="usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "usuario")
    private List<TipoUsuario> tipoUsuario;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Anuncio> anuncios;
    private String nome;
    private String email;
    private String senha;

}

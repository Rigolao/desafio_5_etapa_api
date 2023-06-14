package unaerp.estagios.api.usuarios;

import jakarta.persistence.*;
import lombok.*;
import unaerp.estagios.api.anuncios.Anuncio;

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
    @Column(name = "tipoUsuario")
    private Boolean tipoUsuario; // TRUE: USUARIO(1), FALSE: ANUNCIANTE(0)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Anuncio> anuncios;
    private String nome;
    private String email;
    private String senha;

    public Usuario(DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.senha = dados.senha();
        this.email = dados.email();
        this.tipoUsuario = dados.tipo();
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }

}

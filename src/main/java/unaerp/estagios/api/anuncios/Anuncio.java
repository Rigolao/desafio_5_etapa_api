package unaerp.estagios.api.anuncios;

import jakarta.persistence.*;
import lombok.*;
import unaerp.estagios.api.usuarios.Usuario;

import java.util.Date;

@Table(name="anuncios")
@Entity(name = "Anuncio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @Column(name = "areaConhecimento")
    private String areaConhecimento;
    private String descricao;
    private String email;
    private String telefone;
    private Date dataInicio;
    private Date dataFim;
    private String exibir;
    private Integer status;
    private String localidade;
    private Float remuneracao;

    public Anuncio(DadosCadastroAnuncio dados) {
        this.areaConhecimento = dados.areaConhecimento();
        this.descricao = dados.descricao();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.dataFim = dados.dataFim();
        this.dataInicio = dados.dataInicio();
        this.exibir = dados.exibir();
        this.localidade = dados.localidade();
        this.status = 1;
        this.remuneracao = dados.remuneracao();
    }

    public void atualizarInformacoes(DadosAtualizacaoAnuncio dados) {
        if (dados.areaConhecimento() != null) {
            this.areaConhecimento = dados.areaConhecimento();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataInicio() != null) {
            this.dataInicio = dados.dataInicio();
        }
        if (dados.dataFim() != null) {
            this.dataFim = dados.dataFim();
        }
        if (dados.localidade() != null) {
            this.localidade = dados.localidade();
        }
        if (dados.areaConhecimento() != null) {
            this.areaConhecimento = dados.areaConhecimento();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.exibir() != null) {
            this.exibir = dados.exibir();
        }
    }

    public void excluir () {
        this.status = 0;
    }
}

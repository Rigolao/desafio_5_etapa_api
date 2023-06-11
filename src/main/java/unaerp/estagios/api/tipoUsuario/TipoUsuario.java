package unaerp.estagios.api.tipoUsuario;

import jakarta.persistence.*;
import lombok.*;
import unaerp.estagios.api.usuarios.Usuario;

@Table(name="TIPOUSUARIOS")
@Entity(name = "TIPOUSUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private Tipo tipo;
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private Usuario usuario;
}

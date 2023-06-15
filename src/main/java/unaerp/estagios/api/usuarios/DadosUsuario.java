package unaerp.estagios.api.usuarios;

public record DadosUsuario(Long id,String nome, String senha, String email ) {
    public DadosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getEmail());
    }
}

package unaerp.estagios.api.anuncios;

public enum Status {
    ATIVO (1),
    INATIVO (0);

    private final int codigo;
    Status(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
}

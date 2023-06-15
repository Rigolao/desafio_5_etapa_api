package unaerp.estagios.api.anuncios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    @Query("SELECT a FROM Anuncio a WHERE CURRENT_DATE BETWEEN a.dataInicio AND a.dataFim AND a.exibir = 'S' AND a.status = 1")
    List<Anuncio> findAnunciosExibiveis();

    List<Anuncio> findAll();

}

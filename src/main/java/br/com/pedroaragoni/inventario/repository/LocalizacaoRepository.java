package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
    boolean existsByCodigo(String codigo);
    List<Localizacao> findByAtivoTrue();
}

package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
    boolean existsByCodigo(String codigo);
}

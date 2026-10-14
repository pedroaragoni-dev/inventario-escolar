package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, Long id);
    List<Fabricante> findByAtivoTrue();
}

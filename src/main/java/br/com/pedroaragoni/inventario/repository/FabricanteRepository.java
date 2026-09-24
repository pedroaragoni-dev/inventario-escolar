package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}

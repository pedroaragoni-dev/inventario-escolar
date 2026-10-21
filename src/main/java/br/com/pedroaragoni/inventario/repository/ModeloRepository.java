package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    boolean existsByNomeAndFabricante_IdAndCategoria_Id(
            String nome, Long fabricanteId, Long categoriaId);

    boolean existsByNomeAndFabricante_IdAndCategoria_IdAndIdNot(
            String nome, Long fabricanteId, Long categoriaId, Long id);
}
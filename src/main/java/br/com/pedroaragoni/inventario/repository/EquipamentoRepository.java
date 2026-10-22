package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    boolean existsByNumeroSerie(String numeroSerie);

    @Query(value = "SELECT nextval('equipamento_codigo_seq')", nativeQuery = true)
    Long obterProximoNumeroCodigo();
}

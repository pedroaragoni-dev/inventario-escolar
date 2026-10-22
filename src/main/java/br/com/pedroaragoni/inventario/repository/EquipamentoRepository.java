package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    boolean existsByNumeroSerie(String numeroSerie);

    @Query(value = "SELECT nextval('equipamento_codigo_seq')", nativeQuery = true)
    Long obterProximoNumeroCodigo();

    Optional<Equipamento> findByIdentificadorInterno(String identificadorInterno);

    List<Equipamento> findByAtivoTrue();
}

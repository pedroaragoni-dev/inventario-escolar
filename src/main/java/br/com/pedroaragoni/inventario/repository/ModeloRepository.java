package br.com.pedroaragoni.inventario.repository;

import br.com.pedroaragoni.inventario.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {


}
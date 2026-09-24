package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.repository.FabricanteRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.model.Fabricante;
import java.util.List;

@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    public List<Fabricante> listarTodos() {
        return fabricanteRepository.findAll();
    }
}

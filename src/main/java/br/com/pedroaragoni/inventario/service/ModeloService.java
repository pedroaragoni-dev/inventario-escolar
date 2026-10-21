package br.com.pedroaragoni.inventario.service;

import br.com.pedroaragoni.inventario.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import br.com.pedroaragoni.inventario.model.Modelo;
import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }
}
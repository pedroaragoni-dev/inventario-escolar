package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.service.ModeloService;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.model.Modelo;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/modelos")
    public List<Modelo> listarTodos() {
        return modeloService.listarTodos();
    }
}
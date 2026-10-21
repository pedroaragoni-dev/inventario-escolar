package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.service.ModeloService;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.model.Modelo;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import br.com.pedroaragoni.inventario.dto.ModeloCadastroRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/modelos")
    public Modelo cadastrar(@Valid @RequestBody ModeloCadastroRequest request) {
        return modeloService.cadastrar(
                request.nome(),
                request.fabricanteId(),
                request.categoriaId()
        );
    }
}
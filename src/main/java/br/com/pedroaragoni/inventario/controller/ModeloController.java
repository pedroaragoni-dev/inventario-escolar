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
import org.springframework.web.bind.annotation.PathVariable;
import br.com.pedroaragoni.inventario.dto.ModeloAlteracaoRequest;
import org.springframework.web.bind.annotation.PatchMapping;

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

    @GetMapping("/modelos/{id}")
    public Modelo buscarPorId(@PathVariable("id") Long id) {
        return modeloService.buscarPorId(id);
    }

    @PatchMapping("/modelos/{id}")
    public Modelo alterarNome(
            @PathVariable("id") Long id,
            @Valid @RequestBody ModeloAlteracaoRequest request) {

        return modeloService.alterarNome(id, request.nome());
    }
}
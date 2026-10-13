package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.service.FabricanteService;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.model.Fabricante;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import br.com.pedroaragoni.inventario.dto.FabricanteCadastroRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class FabricanteController {

    private final FabricanteService fabricanteService;

    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @GetMapping("/fabricantes")
    public List<Fabricante> listarTodos() {
        return fabricanteService.listarTodos();
    }

    @PostMapping("/fabricantes")
    public Fabricante cadastrar(@Valid @RequestBody FabricanteCadastroRequest request) {
        return fabricanteService.cadastrar(request.nome());
    }
}

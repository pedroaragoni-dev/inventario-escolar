package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.service.FabricanteService;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.model.Fabricante;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

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
}

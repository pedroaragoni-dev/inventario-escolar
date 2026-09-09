package br.com.pedroaragoni.inventario.controller;

import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.service.CategoriaService;
import br.com.pedroaragoni.inventario.model.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public List<Categoria> listarTodas() {
        return categoriaService.listarTodas();
    }
}
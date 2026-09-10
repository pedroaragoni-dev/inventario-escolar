package br.com.pedroaragoni.inventario.controller;

import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.service.CategoriaService;
import br.com.pedroaragoni.inventario.model.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import br.com.pedroaragoni.inventario.dto.CategoriaCadastroRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/categorias")
    public Categoria cadastrar(@RequestBody CategoriaCadastroRequest request) {
        return categoriaService.cadastrar(request.nome());
    }


}
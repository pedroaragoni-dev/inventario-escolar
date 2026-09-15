package br.com.pedroaragoni.inventario.controller;

import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.service.CategoriaService;
import br.com.pedroaragoni.inventario.model.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import br.com.pedroaragoni.inventario.dto.CategoriaCadastroRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.pedroaragoni.inventario.dto.CategoriaAlteracaoRequest;
import org.springframework.web.bind.annotation.PatchMapping;

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

    @GetMapping("/categorias/ativas")
    public List<Categoria> listarAtivas() {
        return categoriaService.listarAtivas();
    }

    @PostMapping("/categorias")
    public Categoria cadastrar(@Valid @RequestBody CategoriaCadastroRequest request) {
        return categoriaService.cadastrar(request.nome());
    }

    @GetMapping("/categorias/{id}")
    public Categoria buscarPorId(@PathVariable("id") Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PatchMapping("/categorias/{id}")
    public Categoria alterarNome(
            @PathVariable("id") Long id,
            @Valid @RequestBody CategoriaAlteracaoRequest request) {

        return categoriaService.alterarNome(id, request.nome());
    }

    @PatchMapping("/categorias/{id}/inativar")
    public Categoria inativar(@PathVariable("id") Long id) {
        return categoriaService.inativar(id);
    }

    @PatchMapping("/categorias/{id}/reativar")
    public Categoria reativar(@PathVariable("id") Long id) {
        return categoriaService.reativar(id);
    }

}
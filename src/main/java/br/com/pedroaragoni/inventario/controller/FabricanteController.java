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
import org.springframework.web.bind.annotation.PathVariable;
import br.com.pedroaragoni.inventario.dto.FabricanteAlteracaoRequest;
import org.springframework.web.bind.annotation.PatchMapping;

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

    @GetMapping("/fabricantes/ativos")
    public List<Fabricante> listarAtivos() {
        return fabricanteService.listarAtivos();
    }

    @PostMapping("/fabricantes")
    public Fabricante cadastrar(@Valid @RequestBody FabricanteCadastroRequest request) {
        return fabricanteService.cadastrar(request.nome());
    }

    @GetMapping("/fabricantes/{id}")
    public Fabricante buscarPorId(@PathVariable("id") Long id) {
        return fabricanteService.buscarPorId(id);
    }

    @PatchMapping("/fabricantes/{id}")
    public Fabricante alterarNome(
            @PathVariable("id") Long id,
            @Valid @RequestBody
            FabricanteAlteracaoRequest request) {
        return fabricanteService.alterarNome(id, request.nome());
    }

    @PatchMapping("/fabricantes/{id}/inativar")
    public Fabricante inativar(@PathVariable("id") Long id) {
        return fabricanteService.inativar(id);
    }

    @PatchMapping("/fabricantes/{id}/reativar")
    public Fabricante reativar(@PathVariable("id") Long id) {
        return fabricanteService.reativar(id);
    }


}

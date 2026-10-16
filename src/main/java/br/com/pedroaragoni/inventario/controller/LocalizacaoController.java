package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.service.LocalizacaoService;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.model.Localizacao;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import br.com.pedroaragoni.inventario.dto.LocalizacaoCadastroRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.pedroaragoni.inventario.dto.LocalizacaoAlteracaoRequest;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping("/localizacoes")
    public List<Localizacao> listarTodas() {
        return localizacaoService.listarTodas();
    }

    @PostMapping("/localizacoes")
    public Localizacao cadastrar(@Valid @RequestBody LocalizacaoCadastroRequest request) {
        return localizacaoService.cadastrar(
                request.codigo(),
                request.nome(),
                request.descricao()
        );
    }

    @GetMapping("/localizacoes/{id}")
    public Localizacao buscarPorId(@PathVariable("id") Long id) {
        return localizacaoService.buscarPorId(id);
    }

    @PatchMapping("/localizacoes/{id}")
    public Localizacao alterarDados(
            @PathVariable("id") Long id,
            @Valid @RequestBody LocalizacaoAlteracaoRequest request) {

        return localizacaoService.alterarDados(
                id,
                request.nome(),
                request.descricao()
        );
    }
}
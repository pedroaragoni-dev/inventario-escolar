package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.service.LocalizacaoService;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.model.Localizacao;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

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
}
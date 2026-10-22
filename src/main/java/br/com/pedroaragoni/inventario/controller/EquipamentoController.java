package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.model.Equipamento;
import br.com.pedroaragoni.inventario.service.EquipamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.pedroaragoni.inventario.dto.EquipamentoCadastroRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.pedroaragoni.inventario.dto.EquipamentoCondicaoRequest;
import org.springframework.web.bind.annotation.PatchMapping;
import br.com.pedroaragoni.inventario.dto.EquipamentoLocalizacaoRequest;

@RestController
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping("/equipamentos")
    public List<Equipamento> listarTodos() {
        return equipamentoService.listarTodos();
    }

    @PostMapping("/equipamentos")
    public Equipamento cadastrar(
            @Valid @RequestBody EquipamentoCadastroRequest request) {

        return equipamentoService.cadastrar(
                request.numeroSerie(),
                request.modeloId(),
                request.localizacaoId(),
                request.statusFuncionamento(),
                request.observacoes()
        );
    }

    @GetMapping("/equipamentos/{id}")
    public Equipamento buscarPorId(@PathVariable("id") Long id) {
        return equipamentoService.buscarPorId(id);
    }

    @GetMapping("/equipamentos/codigo/{codigo}")
    public Equipamento buscarPorCodigo(@PathVariable("codigo") String codigo) {
        return equipamentoService.buscarPorCodigo(codigo);
    }

    @PatchMapping("/equipamentos/{id}/condicao")
    public Equipamento alterarCondicao(
            @PathVariable("id") Long id,
            @Valid @RequestBody EquipamentoCondicaoRequest request) {

        return equipamentoService.alterarCondicao(
                id,
                request.statusFuncionamento(),
                request.observacoes()
        );
    }

    @PatchMapping("/equipamentos/{id}/localizacao")
    public Equipamento alterarLocalizacao(
            @PathVariable("id") Long id,
            @Valid @RequestBody EquipamentoLocalizacaoRequest request) {

        return equipamentoService.alterarLocalizacao(
                id,
                request.localizacaoId()
        );
    }

}
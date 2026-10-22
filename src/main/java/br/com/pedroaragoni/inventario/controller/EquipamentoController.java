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
}
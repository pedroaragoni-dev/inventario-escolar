package br.com.pedroaragoni.inventario.controller;

import br.com.pedroaragoni.inventario.model.Equipamento;
import br.com.pedroaragoni.inventario.service.EquipamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
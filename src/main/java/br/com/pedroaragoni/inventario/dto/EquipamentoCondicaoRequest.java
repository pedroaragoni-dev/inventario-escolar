package br.com.pedroaragoni.inventario.dto;

import br.com.pedroaragoni.inventario.model.StatusFuncionamento;
import jakarta.validation.constraints.NotNull;

public record EquipamentoCondicaoRequest(
        @NotNull(message = "O estado de funcionamento é obrigatório")
        StatusFuncionamento statusFuncionamento,

        String observacoes
) {
}
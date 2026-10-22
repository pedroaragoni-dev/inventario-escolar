package br.com.pedroaragoni.inventario.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EquipamentoLocalizacaoRequest(
        @NotNull(message = "A localização é obrigatória")
        @Positive(message = "O identificador da localização deve ser positivo")
        Long localizacaoId
) {
}
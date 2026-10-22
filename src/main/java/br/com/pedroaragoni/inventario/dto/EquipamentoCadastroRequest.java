package br.com.pedroaragoni.inventario.dto;

import br.com.pedroaragoni.inventario.model.StatusFuncionamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EquipamentoCadastroRequest(
        @NotBlank(message = "O número de série é obrigatório")
        @Size(max = 100, message = "O número de série deve ter no máximo 100 caracteres")
        String numeroSerie,

        @NotNull(message = "O modelo é obrigatório")
        @Positive(message = "O identificador do modelo deve ser positivo")
        Long modeloId,

        @NotNull(message = "A localização é obrigatória")
        @Positive(message = "O identificador da localização deve ser positivo")
        Long localizacaoId,

        @NotNull(message = "O estado de funcionamento é obrigatório")
        StatusFuncionamento statusFuncionamento,

        String observacoes
) {
}
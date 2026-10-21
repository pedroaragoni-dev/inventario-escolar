package br.com.pedroaragoni.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ModeloCadastroRequest(
        @NotBlank(message = "O nome do modelo é obrigatório")
        @Size(max = 100, message = "O nome do modelo deve ter no máximo 100 caracteres")
        String nome,

        @NotNull(message = "O fabricante é obrigatório")
        Long fabricanteId,

        @NotNull(message = "A categoria é obrigatória")
        Long categoriaId
) {
}
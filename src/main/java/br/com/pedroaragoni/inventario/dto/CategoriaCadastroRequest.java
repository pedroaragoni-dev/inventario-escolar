package br.com.pedroaragoni.inventario.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaCadastroRequest(
        @NotBlank(message = "O nome da categoria é obrigatório")
        String nome
) {
}

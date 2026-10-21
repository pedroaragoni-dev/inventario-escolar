package br.com.pedroaragoni.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModeloAlteracaoRequest(
        @NotBlank(message = "O nome do modelo é obrigatório")
        @Size(max = 100, message = "O nome do modelo deve ter no máximo 100 caracteres")
        String nome
) {
}
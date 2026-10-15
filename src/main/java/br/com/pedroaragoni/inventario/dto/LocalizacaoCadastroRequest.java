package br.com.pedroaragoni.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LocalizacaoCadastroRequest(
        @NotBlank(message = "O código da localização é obrigatório")
        @Size(max = 20, message = "O código da localização deve ter no máximo 20 caracteres")
        String codigo,

        @NotBlank(message = "O nome da localização é obrigatório")
        @Size(max = 100, message = "O nome da localização deve ter no máximo 100 caracteres")
        String nome,

        String descricao
) {
}
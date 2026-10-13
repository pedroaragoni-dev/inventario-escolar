package br.com.pedroaragoni.inventario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FabricanteCadastroRequest(
        @NotBlank(message = "O nome do fabricante é obrigatório")
        @Size(max = 100, message = "O nome do fabricante deve ter no máximo 100 caracteres")
        String nome
) {
}

package br.com.ricmrs.biblioteca.domain.editora;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEditora(
        @NotBlank
        String nome
) {
}

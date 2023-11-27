package br.com.ricmrs.biblioteca.domain.editora;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEditora(
        @NotNull
        Long id,
        @NotBlank
        String nome
) {
}

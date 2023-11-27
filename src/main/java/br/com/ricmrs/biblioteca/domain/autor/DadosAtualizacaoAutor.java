package br.com.ricmrs.biblioteca.domain.autor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAutor(
        @NotNull
        Long id,
        String nome,
        String sobre) {
}

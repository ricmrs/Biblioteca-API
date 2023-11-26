package br.com.ricmrs.biblioteca.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(
        @NotBlank
        String nome,
        String sobre) {
}

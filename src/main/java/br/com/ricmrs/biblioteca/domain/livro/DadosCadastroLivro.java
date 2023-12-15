package br.com.ricmrs.biblioteca.domain.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLivro(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotNull
        @Positive
        Integer numeroPaginas,
        @NotBlank
        String idioma,
        @NotNull
        Long autorId,
        @NotNull
        Long editoraId,
        @NotNull
        LocalDate dataPublicacao,
        @NotNull
        @Positive
        BigDecimal preco
) {
}

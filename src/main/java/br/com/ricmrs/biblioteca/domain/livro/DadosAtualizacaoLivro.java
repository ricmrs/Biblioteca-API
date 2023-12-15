package br.com.ricmrs.biblioteca.domain.livro;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLivro(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        @Positive
        Integer numeroPaginas,
        String idioma,
        Long autorId,
        Long editoraId,
        LocalDate dataPublicacao,
        @Positive
        BigDecimal preco
) {
}

package br.com.ricmrs.biblioteca.domain.livro;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLivro(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        Integer numeroPaginas,
        String idioma,
        Long autorId,
        Long editoraId,
        LocalDate dataPublicacao,
        BigDecimal preco
) {
}

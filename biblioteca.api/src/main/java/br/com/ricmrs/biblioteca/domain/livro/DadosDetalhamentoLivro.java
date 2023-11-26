package br.com.ricmrs.biblioteca.domain.livro;

import br.com.ricmrs.biblioteca.domain.editora.DadosDetalhamentoEditora;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoLivro(
        Long id,
        String titulo,
        String descricao,
        Integer numeroPaginas,
        String idioma,
        DadosDetalhementoAutorPorLivro autor,
        DadosDetalhamentoEditora editora,
        LocalDate dataPublicacao,
        BigDecimal preco
) {
    public DadosDetalhamentoLivro(Livro livro){
        this(livro.getId(), livro.getTitulo(), livro.getDescricao(),
                livro.getNumeroPaginas(), livro.getIdioma(), livro.getAutor(), livro.getEditora(), livro.getDataPublicacao(), livro.getPreco());
    }
}

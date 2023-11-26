package br.com.ricmrs.biblioteca.domain.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLivro(
        Long id,
        String titulo,
        Integer numeroPaginas,
        Long autorId,
        Long editoraId,
        LocalDate dataPublicacao,
        BigDecimal preco
) {
    public DadosListagemLivro(Livro livro){
        this(livro.getId(), livro.getTitulo(),
                livro.getNumeroPaginas(), livro.getAutor().id(),
                livro.getEditora().id(), livro.getDataPublicacao(), livro.getPreco());
    }
}

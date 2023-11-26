package br.com.ricmrs.biblioteca.domain.autor;

import br.com.ricmrs.biblioteca.domain.livro.Livro;

import java.time.LocalDate;

public record DadosDetalhamentoLivrosDoAutor(
        Long id,
        String titulo,
        LocalDate dataPublicacao
) {
    public DadosDetalhamentoLivrosDoAutor(Livro livro){
        this(livro.getId(), livro.getTitulo(), livro.getDataPublicacao());
    }
}

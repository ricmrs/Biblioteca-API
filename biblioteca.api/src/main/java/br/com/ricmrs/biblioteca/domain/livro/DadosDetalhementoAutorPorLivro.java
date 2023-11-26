package br.com.ricmrs.biblioteca.domain.livro;

import br.com.ricmrs.biblioteca.domain.autor.Autor;

public record DadosDetalhementoAutorPorLivro(
        Long id,
        String nome
) {
    public DadosDetalhementoAutorPorLivro(Autor autor){
        this(autor.getId(), autor.getNome());
    }
}

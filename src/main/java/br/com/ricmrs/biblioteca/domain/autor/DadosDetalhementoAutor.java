package br.com.ricmrs.biblioteca.domain.autor;

import java.util.List;

public record DadosDetalhementoAutor(
        Long id,
        String nome,
        String sobre,
        List<DadosDetalhamentoLivrosDoAutor> livros
) {
    public DadosDetalhementoAutor(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getSobre(),
                autor.getLivros().stream().map(DadosDetalhamentoLivrosDoAutor::new).toList());
    }
}

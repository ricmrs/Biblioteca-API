package br.com.ricmrs.biblioteca.domain.autor;

public record DadosListagemAutor(
        Long id,
        String nome,
        String sobre
) {
    public DadosListagemAutor(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getSobre());
    }
}

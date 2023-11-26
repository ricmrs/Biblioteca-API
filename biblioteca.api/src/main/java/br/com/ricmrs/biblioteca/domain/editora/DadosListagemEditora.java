package br.com.ricmrs.biblioteca.domain.editora;

public record DadosListagemEditora(Long id, String nome) {
    public DadosListagemEditora(Editora editora){
        this(editora.getId(), editora.getNome());
    }
}

package br.com.ricmrs.biblioteca.domain.editora;

public record DadosDetalhamentoEditora(
        Long id,
        String nome
) {
    public DadosDetalhamentoEditora(Editora editora){
        this(editora.getId(), editora.getNome());
    }
}

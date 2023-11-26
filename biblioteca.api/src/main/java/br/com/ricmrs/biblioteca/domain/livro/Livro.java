package br.com.ricmrs.biblioteca.domain.livro;

import br.com.ricmrs.biblioteca.domain.autor.Autor;
import br.com.ricmrs.biblioteca.domain.editora.DadosDetalhamentoEditora;
import br.com.ricmrs.biblioteca.domain.editora.Editora;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "livros")
@Entity(name = "Livro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String titulo;
    private String descricao;
    @Column(name = "numero_paginas")
    private Integer numeroPaginas;
    private String idioma;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "editora_id")
    private Editora editora;
    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;
    private BigDecimal preco;
    public Livro(DadosCadastroLivro dados, Autor autor, Editora editora) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.numeroPaginas = dados.numeroPaginas();
        this.idioma = dados.idioma();
        this.dataPublicacao = dados.dataPublicacao();
        this.preco = dados.preco();
        this.autor = autor;
        this.editora = editora;
    }
    public void atualizarDados(DadosAtualizacaoLivro dados, Autor autor, Editora editora){
        if(dados.titulo() != null && !dados.titulo().isBlank()) this.titulo = dados.titulo();
        if(dados.descricao() != null && !dados.descricao().isBlank()) this.descricao = dados.descricao();
        if(dados.numeroPaginas() != null) this.numeroPaginas = dados.numeroPaginas();
        if(dados.idioma() != null && !dados.idioma().isBlank()) this.idioma = dados.idioma();
        if(dados.preco() != null) this.preco = dados.preco();
        if(dados.dataPublicacao() != null) this.dataPublicacao = dados.dataPublicacao();
        if(autor != null) this.autor = autor;
        if(editora != null) this.editora = editora;
    }
    public void excluir(){
        this.ativo = false;
    }

    public DadosDetalhementoAutorPorLivro getAutor(){
        return new DadosDetalhementoAutorPorLivro(autor);
    }

    public DadosDetalhamentoEditora getEditora(){
        return new DadosDetalhamentoEditora(editora);
    }
}

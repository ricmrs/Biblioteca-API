package br.com.ricmrs.biblioteca.domain.autor;

import br.com.ricmrs.biblioteca.domain.livro.Livro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"livros"})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String sobre;
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor(DadosCadastroAutor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.sobre = dados.sobre();
    }
    public void atualizarDados(DadosAtualizacaoAutor dados){
        if(dados.nome() != null && !dados.nome().isBlank()) this.nome = dados.nome();
        if(dados.sobre() != null) this.sobre = dados.sobre();
    }
    public void excluir(){
        this.ativo = false;
    }
}

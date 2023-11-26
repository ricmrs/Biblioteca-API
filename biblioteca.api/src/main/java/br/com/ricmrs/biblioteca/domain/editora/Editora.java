package br.com.ricmrs.biblioteca.domain.editora;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "editoras")
@Entity(name = "Editora")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    public Editora(DadosCadastroEditora dados){
        this.ativo = true;
        this.nome = dados.nome();
    }
    public void atualizarDados(DadosAtualizacaoEditora dados){
        this.nome = dados.nome();
    }
    public void excluir(){
        this.ativo = false;
    }
}

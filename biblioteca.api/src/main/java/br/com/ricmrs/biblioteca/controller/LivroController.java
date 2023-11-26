package br.com.ricmrs.biblioteca.controller;

import br.com.ricmrs.biblioteca.domain.autor.Autor;
import br.com.ricmrs.biblioteca.domain.autor.AutorRepository;
import br.com.ricmrs.biblioteca.domain.editora.Editora;
import br.com.ricmrs.biblioteca.domain.editora.EditoraRepository;
import br.com.ricmrs.biblioteca.api.domain.livro.*;
import br.com.ricmrs.biblioteca.domain.livro.*;
import br.com.ricmrs.biblioteca.infra.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditoraRepository editoraRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLivro> cadastrar(@RequestBody @Valid DadosCadastroLivro dados, UriComponentsBuilder uriBuilder){
        Autor autor = autorRepository.getReferenceById(dados.autorId());
        Editora editora = editoraRepository.getReferenceById(dados.editoraId());
        var livro = new Livro(dados, autor, editora);
        livroRepository.save(livro);
        var uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhamentoLivro(livro));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLivro>> listarTodos(@PageableDefault(size = 10) Pageable paginacao){
        var page = livroRepository.findAllByAtivoTrue(paginacao).map(DadosListagemLivro::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoLivro> atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados) {
        if(dados.autorId() != null && !autorRepository.existsById(dados.autorId())) {
            throw new ValidacaoException("Id do autor informado não existe.");
        }
        if(dados.editoraId() != null && !editoraRepository.existsById(dados.editoraId())){
            throw new RuntimeException("Id da editora informado não existe.");
        }

        Livro livro = livroRepository.getReferenceById(dados.id());
        Autor autor = null;
        Editora editora = null;

        if(dados.autorId() != null){
            autor = autorRepository.getReferenceById(dados.autorId());
        }

        if(dados.editoraId() != null){
            editora = editoraRepository.getReferenceById(dados.editoraId());
        }

        livro.atualizarDados(dados, autor, editora);
        return ResponseEntity.ok(new DadosDetalhamentoLivro(livro));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Livro livro = livroRepository.getReferenceById(id);
        livro.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLivro> detalhar(@PathVariable Long id){
        Livro livro = livroRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLivro(livro));
    }
}

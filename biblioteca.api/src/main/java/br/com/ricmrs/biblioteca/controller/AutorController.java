package br.com.ricmrs.biblioteca.controller;

import br.com.ricmrs.biblioteca.api.domain.autor.*;
import br.com.ricmrs.biblioteca.domain.autor.*;
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
@RequestMapping("autores")
public class AutorController {
    @Autowired
    private AutorRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhementoAutor> cadastrar(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder){
        var autor = new Autor(dados);
        repository.save(autor);
        var uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhementoAutor(autor));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemAutor>> listarTodos(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAutor::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhementoAutor> atualizar(@RequestBody @Valid DadosAtualizacaoAutor dados) {
        Autor autor = repository.getReferenceById(dados.id());
        autor.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhementoAutor(autor));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Autor autor = repository.getReferenceById(id);
        autor.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhementoAutor> detalhar(@PathVariable Long id){
        Autor autor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhementoAutor(autor));
    }
}

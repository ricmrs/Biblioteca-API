package br.com.ricmrs.biblioteca.controller;

import br.com.ricmrs.biblioteca.domain.editora.*;
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
@RequestMapping("editoras")
public class EditoraController {
    @Autowired
    private EditoraRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEditora> cadastrar(@RequestBody @Valid DadosCadastroEditora dados, UriComponentsBuilder uriBuilder){
        var editora = new Editora(dados);
        repository.save(editora);
        var uri = uriBuilder.path("/editoras/{id}").buildAndExpand(editora.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhamentoEditora(editora));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemEditora>> listarTodos(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemEditora::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEditora> atualizar(@RequestBody @Valid DadosAtualizacaoEditora dados) {
        Editora editora = repository.getReferenceById(dados.id());
        editora.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEditora(editora));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Editora editora = repository.getReferenceById(id);
        editora.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEditora> detalhar(@PathVariable Long id){
        Editora editora = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEditora(editora));
    }
}

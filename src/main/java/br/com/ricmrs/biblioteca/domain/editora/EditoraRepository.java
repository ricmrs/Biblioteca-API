package br.com.ricmrs.biblioteca.domain.editora;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Page<Editora> findAllByAtivoTrue(Pageable paginacao);
}

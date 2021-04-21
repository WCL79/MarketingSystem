package br.com.zup.repositories;

import br.com.zup.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);
    Iterable<Categoria> findByIdOrNome(Integer id, String nome);
}
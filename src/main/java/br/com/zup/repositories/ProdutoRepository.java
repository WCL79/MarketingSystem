package br.com.zup.repositories;

import br.com.zup.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);
}

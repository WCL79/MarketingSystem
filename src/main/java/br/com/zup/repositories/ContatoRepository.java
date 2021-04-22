package br.com.zup.repositories;

import br.com.zup.model.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
    Boolean existsByEmail(String email);
}

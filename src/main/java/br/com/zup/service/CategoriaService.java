package br.com.zup.service;

import br.com.zup.model.Categoria;
import br.com.zup.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoriaService {


    private final CategoriaRepository categoriaRepository;


    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria pesquisarCategoriaPorNome(Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findByNome(categoria.getNome());
        if(optionalCategoria.isEmpty()){
            return salvar(categoria);
        }
        return optionalCategoria.get();
    }
}
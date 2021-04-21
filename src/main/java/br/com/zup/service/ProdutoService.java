package br.com.zup.service;

import br.com.zup.model.Categoria;
import br.com.zup.model.Produto;
import br.com.zup.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private CategoriaService categoriaService;

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(CategoriaService categoriaService, ProdutoRepository produtoRepository) {
        this.categoriaService = categoriaService;
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProdutoNovo(Produto produto){
        List<Categoria> categorias = criarListaDeCategoriaParaRegistarCasoNomeInexistente(produto.getCategorias());
        produto.setCategorias(categorias);
        return produtoRepository.save(produto);
    }

    private List<Categoria> criarListaDeCategoriaParaRegistarCasoNomeInexistente(List<Categoria> categorias) {
        List<Categoria> categoriasAdcionarNoProduto = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriasAdcionarNoProduto.add(categoriaService.pesquisarCategoriaPorNome(categoria));
        }
        return categoriasAdcionarNoProduto;
    }

}

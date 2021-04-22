package br.com.zup.service;

import br.com.zup.dto.output.SaidaContatoDTO;
import br.com.zup.dto.output.SaidaProdutoDTO;
import br.com.zup.model.Contato;
import br.com.zup.model.Produto;
import br.com.zup.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository, ProdutoService produtoService, CategoriaService categoriaService) {
        this.contatoRepository = contatoRepository;
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    public Contato registrarContato(Contato contato) {
        if (!contatoRepository.existsByEmail(contato.getEmail())) {
            contato.setProduto(verificarProdutos(contato.getProduto()));
            return contatoRepository.save(contato);
        }
        return contatoRepository.save(contato);
    }

    private List<Produto> verificarProdutos(List<Produto> produtos) {
        List<Produto> produtosAdcionarContato = new ArrayList<>();
        for (Produto produto : produtos) {
            produtosAdcionarContato.add(produtoService.procurarProdutoPorNome(produto.getNome()));
        }
        return produtosAdcionarContato;
    }

    public Iterable<Contato> buscarTodosContatos() {
        return contatoRepository.findAll();
    }

    public Contato procurarContatoPorId(Integer id) {
        Optional<Contato> optionalContato = contatoRepository.findById(id);
        if (optionalContato.isEmpty()) {
            return optionalContato.orElseThrow( () -> new RuntimeException("Contato com id " + id + " não existe") );
        }
        return optionalContato.get();
    }
    public Contato deletarContato(Integer contato) {
        Contato contato1 = procurarContatoPorId(contato);
        contato1.setProduto(null);
        contatoRepository.save(contato1);
        contatoRepository.delete(contato1);
        return contato1;
    }
    public void excluirContatoPorId(Integer id) {
        Contato contato = procurarContatoPorId(id);
        contato.setProduto(null);
        contato = contatoRepository.save(contato);
        contatoRepository.delete(contato);
    }

    public boolean verificarContatoPorId(Integer id){
        return contatoRepository.existsById(id);
    }

    public Contato atualizarContato(Contato contato){
        Contato contatoAntigo = procurarContatoPorId(contato.getId());
        contatoAntigo.setProduto(verificarProdutos(contato.getProduto()));
        contatoAntigo.setEmail(contato.getEmail());
        contatoAntigo.setNome(contato.getNome());
        contatoAntigo.setTelefone(contato.getTelefone());
        return contatoRepository.save(contatoAntigo);
    }

}



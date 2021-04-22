package br.com.zup.dto.input;

import br.com.zup.model.Contato;
import br.com.zup.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class EntradaContatoDTO {

    private String nome;
    private String email;
    private String telefone;
    private List<String> produtos;

    public Contato converterDtoParaModelo() {
        return new Contato(
                null,
                nome,
                email,
                telefone,
                converterListaContatoProdutoDtoParaListaModelo());
    }

    private List<Produto> converterListaContatoProdutoDtoParaListaModelo() {
        List<Produto> produtosModelo = new ArrayList<>();
        produtos.stream().forEach(nome ->{produtosModelo.add( new Produto(null, nome, null));});
        //for (String nome : produtos) {
        // produtosModelo.add(new Produto(nome, null));
        return produtosModelo;
        }
}

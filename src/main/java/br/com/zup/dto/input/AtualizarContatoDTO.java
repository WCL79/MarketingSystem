package br.com.zup.dto.input;

import br.com.zup.model.Contato;
import br.com.zup.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AtualizarContatoDTO {


    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String nome;
    @CPF(message = "{validacao.email_invalido}")
    private String email;
    @NotEmpty
    private String telefone;
    private List<String> produtos;

    public Contato converterDtoParaModelo(Integer id) {
        return new Contato(
                id,
                email,
                nome,
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

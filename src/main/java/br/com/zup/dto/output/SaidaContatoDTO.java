package br.com.zup.dto.output;

import br.com.zup.model.Contato;
import br.com.zup.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class SaidaContatoDTO {

    private Integer id;
    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String nome;
    @CPF(message = "{validacao.email_invalido}")
    private String email;
    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String telefone;
    private List<SaidaProdutoDTO> produtos;

    public SaidaContatoDTO(Integer id, String nome, String email, String telefone) {
    }


    public static SaidaContatoDTO converterDTOParaModelo(Contato contato){
        return new SaidaContatoDTO(
                contato.getId(),
                contato.getNome(),
                contato.getEmail(),
                contato.getTelefone(),
                saidaProdutoDTOS(contato.getProduto()));
    }

    private static List<SaidaProdutoDTO> saidaProdutoDTOS(List<Produto> produtos){
        List<SaidaProdutoDTO> saidaProdutoDTOS = new ArrayList<>();
        produtos.forEach(produto -> { saidaProdutoDTOS.add(SaidaProdutoDTO.converterDTOParaModel(produto));});
        return saidaProdutoDTOS;
    }

    public static List<SaidaContatoDTO> converterListaModeloParaListaDto(Iterable<Contato> contatos) {
        List<SaidaContatoDTO> dtoSaida = new ArrayList<>();
        contatos.forEach(contato -> { dtoSaida.add(converterDTOParaModelo(contato));});
        return dtoSaida;
    }
}

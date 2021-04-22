package br.com.zup.dto.output;

import br.com.zup.model.Categoria;
import br.com.zup.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SaidaProdutoDTO {

    private Integer id;
    private String nome;
    private List<SaidaCategoriaDTO> categorias;

    public SaidaProdutoDTO(Integer id, String nome, List<SaidaCategoriaDTO> categorias) {
        this.id = id;
        this.nome = nome;
        this.categorias = categorias;
    }

    public SaidaProdutoDTO(Integer id, String nome) {
    }

    public static SaidaProdutoDTO converterDTOParaModel(Produto produto) {
        List<SaidaCategoriaDTO> categoriasNomes = SaidaCategoriaDTO.gerarListaDeDto(produto.getCategorias());
        return new SaidaProdutoDTO(produto.getId(), produto.getNome(), categoriasNomes);
    }
}

package br.com.zup.dto.output;

import br.com.zup.model.Categoria;
import br.com.zup.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaidaProdutoDTO {

    private Integer id;
    private String nome;
    private List<String> categorias;

    public static SaidaProdutoDTO converterDTOParaModel(Produto produto){
        List<String> categoriasNomes = new ArrayList<>();
        produto.getCategorias().stream().forEach(categoria -> {
            categoriasNomes.add(categoria.getNome()); });
        return new SaidaProdutoDTO(produto.getId(), produto.getNome(), categoriasNomes);
    }
}

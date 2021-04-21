package br.com.zup.dto.input;

import br.com.zup.model.Categoria;
import br.com.zup.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaProdutoDTO {

    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String nome;

    @NotNull(message = "O campo categorias não foi informado")
    @Size(min = 1, message = "deve ser informado ao menos uma categoria")
    private List<String> categorias;

    public Produto converterDTOParaModel(){
        List<Categoria> categoriasModelo = new ArrayList<>();
        categorias.stream().forEach(nome -> {
            categoriasModelo.add(
                    new Categoria(null, nome)
            );
        });
        return new Produto(null, this.nome, categoriasModelo);
    }
}

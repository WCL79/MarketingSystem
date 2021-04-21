package br.com.zup.dto.output;

import br.com.zup.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor//Construtor com todos argumentos
public class SaidaCategoriaDTO {

    @NotNull
    @NotEmpty
    private Integer id;
    private String nome;

    public static SaidaCategoriaDTO converterModeloParaDTO(Categoria categoria){
        return new SaidaCategoriaDTO(categoria.getId(), categoria.getNome());
    }

}

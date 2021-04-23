package br.com.zup.dto.output;

import br.com.zup.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor//Construtor com todos argumentos
public class SaidaCategoriaDTO {

    @NotNull
    @NotEmpty
    private Integer id;
    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String nome;

    public static SaidaCategoriaDTO converterModeloParaDTO(Categoria categoria){
        return new SaidaCategoriaDTO(
                categoria.getId(),
                categoria.getNome()
        );
    }

    public static List<SaidaCategoriaDTO> gerarListaDeDto(List<Categoria> categorias) {
        List<SaidaCategoriaDTO> dtos = new ArrayList<>();
        for (Categoria categoria : categorias) {
            dtos.add(converterModeloParaDTO(categoria));
        }
        return dtos;
    }

}

package br.com.zup.dto.input;

import br.com.zup.model.Categoria;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
public class EntradaCategoriaDTO {


    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String nome;

    public Categoria converterDTO(){
        return new Categoria(null, this.nome);
    }

}

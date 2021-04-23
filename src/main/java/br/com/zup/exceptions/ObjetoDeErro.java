package br.com.zup.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class ObjetoDeErro {
    private String mensagem;
    private String campo;
}

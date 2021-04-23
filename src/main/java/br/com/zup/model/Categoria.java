package br.com.zup.model;


import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor//Construtor com todos argumentos
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "{validacao.nome_obrigatorio}")
    private String nome;

    public Categoria() {
    }
}
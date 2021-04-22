package br.com.zup.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 155)
    private String nome;

    @ManyToMany
    private List<Categoria> categorias;

    public Produto(Integer id, String nome, List<Categoria> categorias) {
        this.id = id;
        this.nome = nome;
        this.categorias = categorias;
    }
}

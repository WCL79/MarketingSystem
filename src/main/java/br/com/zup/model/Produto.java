package br.com.zup.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor//Construtor com todos argumentos
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 155)
    private String nome;

    @ManyToMany
    private List<Categoria> categorias;

    public Produto() {
    }
}

package br.com.zup.model;


import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Produto {

    @Id
    private String nome;

    @ManyToMany
    private List<Categoria> categorias;
}

package br.com.zup.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;

    @ManyToMany
    private List<Categoria> categorias;
}

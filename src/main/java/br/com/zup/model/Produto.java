package br.com.zup.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
}

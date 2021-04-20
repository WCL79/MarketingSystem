package br.com.zup.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor//Construtor com todos argumentos
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    private String email;

    @Column(name = "nome_completo", length = 120)
    private String nomeCompleto;

    private String telefone;

    @ManyToMany
    private List<Produto> produto;

    public Contato() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(getEmail(), contato.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}

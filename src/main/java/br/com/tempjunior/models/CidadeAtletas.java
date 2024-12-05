package br.com.tempjunior.models;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class CidadeAtletas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    public CidadeAtletas(String nome) {
        this.nome = nome;
    }

    public CidadeAtletas() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CidadeAtletas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

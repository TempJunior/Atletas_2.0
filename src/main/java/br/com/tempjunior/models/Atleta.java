package br.com.tempjunior.models;

import javax.persistence.*;
import java.time.LocalDate;

//Mapeamento de uma entidade, mostrando que essa classe representa uma tabela no banco de dados
@Entity
@Table(name = "atletas")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carteiraDeCadastro;
    private String nome;

    @Enumerated(EnumType.STRING)
    private PaisesPermitido pais;

    @Enumerated(EnumType.STRING)
    private Genero sexo;

    private int idade;
    private double melhorTempo;
    private final LocalDate DATACADASTRO = LocalDate.now();

    @ManyToOne
    private CidadeAtletas cidade;

    public Atleta(String nome, PaisesPermitido pais, Genero sexo, int idade, double melhorTempo, CidadeAtletas cidade) {
        this.nome = nome;
        this.pais = pais;
        this.sexo = sexo;
        this.idade = idade;
        this.melhorTempo = melhorTempo;
        this.cidade = cidade;
    }

    public Atleta() {
    }

    public CidadeAtletas getCidade() {
        return cidade;
    }

    public void setCidade(CidadeAtletas cidade) {
        this.cidade = cidade;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDATACADASTRO() {
        return DATACADASTRO;
    }

    public Long getCarteiraDeCadastro() {
        return carteiraDeCadastro;
    }

    public void setCarteiraDeCadastro(Long carteiraDeCadastro) {
        this.carteiraDeCadastro = carteiraDeCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PaisesPermitido getPais() {
        return pais;
    }

    public Genero getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getMelhorTempo() {
        return melhorTempo;
    }

    public void setMelhorTempo(double melhorTempo) {
        this.melhorTempo = melhorTempo;
    }
}

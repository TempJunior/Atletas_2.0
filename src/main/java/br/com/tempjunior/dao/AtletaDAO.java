package br.com.tempjunior.dao;

import br.com.tempjunior.models.Atleta;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaDAO implements IGenericDAO<Atleta>{

    private EntityManager em;

    public AtletaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Atleta atleta){
        this.em.persist(atleta);
    }

    public void atualizar(Atleta atleta){
        this.em.merge(atleta);
    }

    public Atleta listar(Long id){
        return em.find(Atleta.class, id);
    }
    public void deletar(Atleta atleta){
        atleta = this.em.merge(atleta);
        this.em.remove(atleta);
    }

    public void deletarPorId(Long id) {
        Atleta atleta = em.find(Atleta.class, id);
        if (atleta != null) {
            em.remove(atleta);
        }
    }

    public List<Atleta> buscarTodos(){
        String jpql = "SELECT a FROM Atleta a";
        return this.em.createQuery(jpql, Atleta.class).getResultList();
    }

    public List<Atleta> buscarPorNome(String nome){
        String jpql = "SELECT a FROM Atleta a WHERE a.nome = :nome";
        return this.em.createQuery(jpql, Atleta.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Atleta> buscarPorNomeDaCidade(String nome){
        String jpql = "SELECT a FROM Atleta a WHERE a.cidade.nome = :nome";
        return this.em.createQuery(jpql, Atleta.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public Double buscaPorAtributo(){
        String jpql = "SELECT a.melhorTempo FROM Atleta a";
        return this.em.createQuery(jpql, Double.class)
                .getSingleResult();
    }

}

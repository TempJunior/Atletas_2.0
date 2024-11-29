package br.com.tempjunior.dao;

import br.com.tempjunior.models.Atleta;

import javax.persistence.EntityManager;

public class AtletaDAO {
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
}

package br.com.tempjunior.dao;

import br.com.tempjunior.models.CidadeAtletas;

import javax.persistence.EntityManager;

public class CidadeDAO {
    private EntityManager em;

    public CidadeDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(CidadeAtletas cidade){
        this.em.persist(cidade);
    }

    public void atualizar(CidadeAtletas cidade){
        this.em.merge(cidade);
    }
}

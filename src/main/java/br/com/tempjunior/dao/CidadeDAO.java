package br.com.tempjunior.dao;

import br.com.tempjunior.models.CidadeAtletas;

import javax.persistence.EntityManager;

public class CidadeDAO implements ICidadeDAO<CidadeAtletas>{
    private EntityManager em;

    public CidadeDAO(EntityManager em) {
        this.em = em;
    }

    public void atualizar(CidadeAtletas cidade){
        this.em.merge(cidade);
    }

    @Override
    public void cadastrar(CidadeAtletas cidade) {
        cidade = this.em.merge(cidade);
        this.em.remove(cidade);
    }

    @Override
    public void deletar(CidadeAtletas cidade) {
        cidade = this.em.merge(cidade);
        this.em.remove(cidade);
    }

    @Override
    public void deletarPorId(Long id) {
        CidadeAtletas cidade = em.find(CidadeAtletas.class, id);
        if (cidade != null) {
            em.remove(cidade);
        }
    }
}

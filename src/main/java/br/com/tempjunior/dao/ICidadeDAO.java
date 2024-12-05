package br.com.tempjunior.dao;
import br.com.tempjunior.models.CidadeAtletas;

public interface ICidadeDAO <T>{
    void cadastrar(T entity);
    void atualizar(T entity);
    void deletar(T entity);
    void deletarPorId(Long id);
}

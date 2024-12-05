package br.com.tempjunior.dao;

import br.com.tempjunior.models.Atleta;

import java.util.List;

public interface IGenericDAO <T>{
        void cadastrar(T entity);
        void atualizar(T entity);
        T listar(Long id);
        void deletar(T entity);
        void deletarPorId(Long id);
        List<Atleta> buscarTodos();
        List<Atleta> buscarPorNome(String nome);
        List<Atleta> buscarPorNomeDaCidade(String nome);
        Double buscaPorAtributo();
}

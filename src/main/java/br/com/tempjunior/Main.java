package br.com.tempjunior;

import br.com.tempjunior.dao.AtletaDAO;
import br.com.tempjunior.dao.CidadeDAO;
import br.com.tempjunior.models.Atleta;
import br.com.tempjunior.models.CidadeAtletas;
import br.com.tempjunior.models.Genero;
import br.com.tempjunior.models.PaisesPermitido;
import br.com.tempjunior.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static CidadeAtletas catimbau = new CidadeAtletas("Catimbau");
    static CidadeAtletas alagoas = new CidadeAtletas("Alagoas");
    static Atleta atleta = new Atleta("Junior Oliveira", PaisesPermitido.BRASIL, Genero.MASCULINO, 24, 2.9, alagoas);

    public static void main(String[] args) {
        //cadastrar();
        EntityManager em = JPAUtil.getEntityManager();

        AtletaDAO atletaDao = new AtletaDAO(em);

        Atleta listar = atletaDao.listar(12l);
        System.out.println(listar);

        List<Atleta> listarTodos = atletaDao.buscarTodos();

        listarTodos.forEach(p -> System.out.println("Nome: "+p.getNome() +", Idade "+ p.getIdade() +",Cidade: "+ p.getCidade().getNome()));

        List<Atleta> buscarPorNome = atletaDao.buscarPorNome("Junior Oliveira");
        buscarPorNome.forEach(p -> System.out.println(p.getNome() + p.getCidade().getNome()));

        List<Atleta> buscaPorCidade = atletaDao.buscarPorNomeDaCidade("Alagoas");
        buscaPorCidade.forEach(p -> System.out.println("Nome: "+p.getNome() + " Cidade: " +p.getCidade().getNome()));

        Double atletaComMelhorTempo = atletaDao.buscaPorAtributo();
        System.out.println("Tempo: "+atletaComMelhorTempo);
    }
    public static void cadastrar(){
        EntityManager em = JPAUtil.getEntityManager();

        CidadeDAO cidadeDao = new CidadeDAO(em);
        AtletaDAO atletaDao = new AtletaDAO(em);

        em.getTransaction().begin();
        cidadeDao.cadastrar(alagoas);
        //cidadeDao.cadastrar(alagoas);
        //cidadeDao.cadastrar(catimbau);
        atletaDao.cadastrar(atleta);
        em.getTransaction().commit();
        em.close();
    }
}
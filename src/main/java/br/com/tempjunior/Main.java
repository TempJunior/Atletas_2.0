package br.com.tempjunior;

import br.com.tempjunior.dao.AtletaDAO;
import br.com.tempjunior.dao.CidadeDAO;
import br.com.tempjunior.models.Atleta;
import br.com.tempjunior.models.CidadeAtletas;
import br.com.tempjunior.models.Genero;
import br.com.tempjunior.models.PaisesPermitido;
import br.com.tempjunior.util.JPAUtil;

import javax.persistence.EntityManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static CidadeAtletas catimbau = new CidadeAtletas("Catimbau");
    static CidadeAtletas alagoas = new CidadeAtletas("Alagoas");
    static Atleta atleta = new Atleta("Bruno Santos", PaisesPermitido.MEXICO, Genero.MASCULINO, 20, 2.9, alagoas);

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CidadeDAO cidadeDao = new CidadeDAO(em);
        AtletaDAO atletaDao = new AtletaDAO(em);

        em.getTransaction().begin();
        cidadeDao.cadastrar(alagoas);
        //cidadeDao.cadastrar(alagoas);
        //cidadeDao.cadastrar(catimbau);
        atletaDao.cadastrar(atleta);
        em.flush();
        em.clear();

        atletaDao.atualizar(atleta);

        atleta.setNome("Roberto");
        em.flush();
        atletaDao.deletar(atleta);
        em.flush();
    }

}
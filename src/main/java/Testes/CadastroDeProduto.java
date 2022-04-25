package Testes;

import dao.ProdutoDao;
import domain.model.Produto;
import enuns.Categoria;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Produto celular = new Produto("Xiaomi Redmi","Muito legal",new BigDecimal("800"), Categoria.CELULARES);


        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();


        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();


    }
}

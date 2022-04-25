package Testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import domain.model.Categoria;
import domain.model.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Categoria categoriaCelular = new Categoria("Celular");
        Produto celular = new Produto("Xiaomi Redmi","Muito legal",new BigDecimal("800"),categoriaCelular );


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);


        em.getTransaction().begin();

        categoriaDao.cadastrar(categoriaCelular);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();


    }
}

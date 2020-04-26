package dao;

import java.util.List;

import javax.persistence.EntityManager;

import connection.ConnectionFactory;
import entities.Produto;

public class ProdutoDaoImpl implements ProdutoDao{
	
	EntityManager em = new ConnectionFactory().getConnection();

	@Override
	public Produto save(Produto produto) {

		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return produto;
	}

	@Override
	public Produto update(Produto produto) {
		
		try {
			em.getTransaction().begin();
			em.merge(produto);
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return produto;
	}

	@Override
	public Produto findById(Integer id) {
		Produto produto = null;
		
		try {
			produto = em.find(Produto.class, id);
		} catch(Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> findAll() {
		List<Produto> produtos = null;
		
		try {
			produtos = em.createQuery("from Produto").getResultList();
		} catch(Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		
		return produtos;
	}

	@Override
	public Produto remove(Integer id) {
		Produto p = null;
		try {
			p = em.find(Produto.class, id);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
		return p;
	}

}

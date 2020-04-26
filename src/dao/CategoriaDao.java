package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import connection.ConnectionFactory;
import entities.Categoria;

public class CategoriaDao {
	
	EntityManager em = new ConnectionFactory().getConnection();
	
	public Categoria saveOrUpdate(Categoria categoria) {
		
		try {
			em.getTransaction().begin();
			if(categoria.getId() == null) {
				em.persist(categoria);
			} else {
				em.merge(categoria);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return categoria;
	}
	
	public Categoria findById(Integer id) {
		
		Categoria categoria = null;
			
		try {
			categoria = em.find(Categoria.class, id);
		} catch(Exception e){
			System.err.println(e);
		} finally {
			em.close();
		}
		return categoria;
	}
	
	public List<Categoria> findAll(){
		
		
		List<Categoria> categorias = null;
		
		try {
			categorias = em.createQuery("from Categoria").getResultList();
		} catch(Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return categorias;
	}
	
	public Categoria removeById(Integer id) {
			Categoria categoria = null;
			
		try {
			categoria = em.find(Categoria.class, id);
			
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
		} catch(Exception e) {	
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
		return categoria;
	}
	
}

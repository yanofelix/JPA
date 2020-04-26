package dao;

import java.util.List;

import entities.Produto;

public interface ProdutoDao {
	
	public Produto save(Produto produto);
	
	public Produto update(Produto produto);
	
	public Produto findById(Integer id);
	
	public List<Produto> findAll();
	
	public Produto remove(Integer id);

}

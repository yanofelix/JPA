package application;

import dao.CategoriaDao;
import entities.Categoria;

public class Program {

	public static void main(String[] args) {
		
		CategoriaDao dao = new CategoriaDao();
		
		dao.removeById(7);		

	}

}

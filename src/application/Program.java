package application;

import dao.ProdutoDao;
import dao.ProdutoDaoImpl;
import entities.Categoria;
import entities.Produto;

public class Program {

	public static void main(String[] args) {

		ProdutoDao dao = new ProdutoDaoImpl();

		for (Produto p : dao.findAll()) {

			System.out.println("Descrição: " + p.getDescricao());
			System.out.println("Qtd: " + p.getQtd());
			System.out.println("Valor: " + p.getValor());
			System.out.println("Categoria: " + p.getCategoria().getDescricao());
		}
	}

}

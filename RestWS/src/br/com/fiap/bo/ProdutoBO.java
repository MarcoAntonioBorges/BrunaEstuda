package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ProdutoTO;

public class ProdutoBO {

	private static ProdutoBO produto;
	private static ArrayList<ProdutoTO> lista = new ArrayList<ProdutoTO>();
	
	public static ProdutoBO getInstance() {
		if(produto == null) {
			produto = new ProdutoBO();
		}
		return produto;
	}
	
	public ProdutoBO() {
		lista.add(new ProdutoTO(401, "Camiseta branca", 50, 25.00));
		lista.add(new ProdutoTO(402, "Camiseta preta", 4, 150));
	}
	
	public ProdutoTO consultaProduto(int codigo) {
		for (ProdutoTO produtoTO : lista) {
			if(produtoTO.getCodigo() == codigo) {
				return produtoTO;
			}
		}
		return null;
	}
	
	public List<ProdutoTO> listar(){
		return lista;
	}
	
	public void cadastrar(ProdutoTO produto) {
		lista.add(produto);
	}
	
	public void remover(int codigo) {
		for (ProdutoTO produtoTO : lista) {
			if(produtoTO.getCodigo() == codigo) {
				lista.remove(produtoTO);
				break;
			}
		}
	}
	
}

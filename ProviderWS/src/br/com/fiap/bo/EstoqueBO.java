package br.com.fiap.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.beans.Camiseta;

public class EstoqueBO {

	public static Camiseta consultaProduto(int codigo) throws AxisFault {
		switch (codigo) {
		case 401:
			
			return new Camiseta(401, 200, 5, "Camiseta azul");

		case 402: 
			return new Camiseta(402, 250, 8, "Camiseta branca");
			
		default:
			throw new AxisFault("Produto não encontrado");
		}
	}
	
}

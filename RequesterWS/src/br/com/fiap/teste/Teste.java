package br.com.fiap.teste;

import java.rmi.RemoteException;
import java.util.Scanner;

import br.com.fiap.bo.EstoqueBOStub;
import br.com.fiap.bo.EstoqueBOStub.Camiseta;
import br.com.fiap.bo.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.bo.EstoqueBOStub.ConsultaProdutoResponse;


public class Teste {

	
	public static void main(String[] args) throws RemoteException {
		
		Scanner teclado = new Scanner(System.in);
		int codigo = 0;
		
		System.out.print("Digite o codigo: ");
		codigo = teclado.nextInt();
		
		// Necessario instanciar a classe do Stub e do Consulta
		EstoqueBOStub stub = new EstoqueBOStub();
		ConsultaProduto consulta = new ConsultaProduto();
		
		
		consulta.setCodigo(codigo);
		
		ConsultaProdutoResponse response = stub.consultaProduto(consulta);
		
		Camiseta camiseta = response.get_return();
		
		System.out.println(camiseta.getAll());
		
	}

	
	
}

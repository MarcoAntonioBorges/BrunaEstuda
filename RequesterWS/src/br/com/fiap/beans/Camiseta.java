package br.com.fiap.beans;

import java.io.Serializable;

public class Camiseta implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private double preco;
	private int qtde;
	private String desc;
	
	
	public String getAll() {
		return "Descricao: " + this.desc + " preco: " + this.preco;
	}
	
	public Camiseta() {
		super();
	}
	
	public Camiseta(int codigo, double preco, int qtde, String desc) {
		super();
		this.codigo = codigo;
		this.preco = preco;
		this.qtde = qtde;
		this.desc = desc;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}

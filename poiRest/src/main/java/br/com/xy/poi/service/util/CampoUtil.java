package br.com.xy.poi.service.util;

/**
 * @author Igor Mendonca
 * 
 *    Classe responsavel por auxiliar metodos de controle de excecoes
 *         .
 * 
 */
public class CampoUtil {
	
	private String nome;
	
	private String valor;

	public CampoUtil(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public CampoUtil(String nome){
		this.nome = nome;
	}

	public CampoUtil() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}

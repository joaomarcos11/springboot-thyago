package br.com.unipe.aula.model;

public class Album {
	
	private Long id;
	
	private String nome;
	private String interprete;
	
	public Album() {}
	
	public Album(String nome, String interprete) {
		super();
		this.nome = nome;
		this.interprete = interprete;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInterprete() {
		return interprete;
	}
	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}
	
}
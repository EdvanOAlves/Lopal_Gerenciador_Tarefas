package br.dev.edvan.gerenciador_tarefas.model;

public class Funcionario {
	private String nome;
	private String cargo;
	private String setor;
	
	public Funcionario(String nome) {
		setNome(nome);
		
	}
	public Funcionario(String nome, String cargo) {
		setNome(nome);
		setCargo(cargo);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}

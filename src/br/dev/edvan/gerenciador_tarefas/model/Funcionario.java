package br.dev.edvan.gerenciador_tarefas.model;

import br.dev.edvan.gerenciador_tarefas.utils.Utils;

public class Funcionario {
	private String matricula;
	private String nome;
	private String cargo;
	private String setor;
	private double salario;
	
	public Funcionario(String nome) {
		setNome(nome);
		setMatricula(Utils.gerarUUID8());
		
	}
	public Funcionario(String nome, String cargo) {
		setNome(nome);
		setCargo(cargo);
		setMatricula(Utils.gerarUUID8());
		
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
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
	
	@Override
	public String toString() {
		
		return matricula + ","+ nome + "," + cargo + "," + setor + "," + salario + "\n";
		
	}


}

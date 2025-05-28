package br.dev.edvan.gerenciador_tarefas.dao;

import java.io.BufferedWriter;

import br.dev.edvan.gerenciador_tarefas.factory.ArquivoFuncionarioFactory;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		ArquivoFuncionarioFactory aff = new ArquivoFuncionarioFactory();

		try {
			BufferedWriter bw = aff.getBw();
			bw.write(funcionario.toString());
			bw.flush();
			//aff.getBw().write(funcionario.toString()).flush(); // Má pratica, só vilões fazem isso
			System.out.println(funcionario.getNome() + " gravado com sucesso!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

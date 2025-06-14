package br.dev.edvan.gerenciador_tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.edvan.gerenciador_tarefas.factory.ArquivoFuncionarioFactory;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;
	ArquivoFuncionarioFactory aff = new ArquivoFuncionarioFactory();

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean gravar() {

		try {
			BufferedWriter bw = aff.getBw();
			bw.write(funcionario.toString());
			bw.flush();
			// aff.getBw().write(funcionario.toString()).flush(); // Má pratica, só vilões
			// fazem isso
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
	}

	public List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			BufferedReader br = aff.getBr();

			String linha = "";

			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					String[] funcionarioVetor = linha.split(",");
					Funcionario funcionario = new Funcionario(null);
					funcionario.setMatricula(funcionarioVetor[0]);
					funcionario.setNome(funcionarioVetor[1]);
					funcionario.setCargo(funcionarioVetor[2]);
					funcionario.setSetor(funcionarioVetor[3]);
					funcionario.setSalario(Double.parseDouble(funcionarioVetor[4]));
					funcionarios.add(funcionario);
				}
			}

			return funcionarios;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public Funcionario findFuncionario(String matricula) {
		Funcionario funcionario;
		
		return funcionario;
	}

}

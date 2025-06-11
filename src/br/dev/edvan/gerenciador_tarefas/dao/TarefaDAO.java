package br.dev.edvan.gerenciador_tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.edvan.gerenciador_tarefas.factory.ArquivoTarefaFactory;
import br.dev.edvan.gerenciador_tarefas.model.Tarefa;

public class TarefaDAO {
	private Tarefa tarefa;
	ArquivoTarefaFactory atf = new ArquivoTarefaFactory();

	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public boolean gravar() {
		try {
			BufferedWriter bw = atf.getBw();
			bw.write(tarefa.toString());
			bw.flush();

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Tarefa> getTarefas(){
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
		try {
			BufferedReader br = atf.getBr();
			String linha = "";
			
			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					String[] tarefaVetor = linha.split(",");
					Tarefa tarefa = new Tarefa(null);
					
					tarefa.setId(tarefaVetor[0]);
					tarefa.setNome(tarefaVetor[1]);
//					tarefa.setResponsavel(tarefaVetor[2]); //TODO: precisa buscar o funcionário pela matricula
//					tarefa.setDataInicio(null); //TODO: Lidar com o LocalDate e a conversão dele
					tarefa.setPrazo(0);
				}
			}
			
			return tarefas;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}

package br.dev.edvan.gerenciador_tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.dev.edvan.gerenciador_tarefas.factory.ArquivoTarefaFactory;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;
import br.dev.edvan.gerenciador_tarefas.model.Status;
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
			return false;
		}
	}

	public List<Tarefa> getTarefas() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();

		try {
			BufferedReader br = atf.getBr();
			String linha = "";

			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					String[] tarefaVetor = linha.split(",");
					Tarefa tarefa = new Tarefa(null);
					FuncionarioDAO daoFuncionario = new FuncionarioDAO(null);

					tarefa.setId(tarefaVetor[0]);
					tarefa.setNome(tarefaVetor[1]);
					tarefa.setDescricao(tarefaVetor[2]);
					tarefa.setResponsavel(daoFuncionario.getFuncionario(tarefaVetor[3]));
					tarefa.setDataInicio(tarefaVetor[5]);
					tarefa.setPrazo(Integer.parseInt(tarefaVetor[6]));
					tarefa.setStatus(tarefaVetor[7]);
					tarefa.setDataEntrega(tarefaVetor[8]);
					// TODO: tarefaVetor[4] guarda o nome do responsável que acaba não sendo
					// relevante.
					// Fazer a substituição do código para otimização depois
					tarefas.add(tarefa);
				}
			}

			return tarefas;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Tarefa getTarefa(String id) {
		List<Tarefa> tarefas = new ArrayList<>();
		tarefas = getTarefas();
		
		String idTemp;
		Tarefa tarefa = null;
		
		for (int i = 0 ; i < tarefas.size(); i++) {
			tarefa = tarefas.get(i);
			idTemp = tarefa.getId();
			if (idTemp.equals(id)) {
				return tarefa;
			}
		}
		return tarefa;
	}

	public void concluirTarefa(String tarefaId) {
		Tarefa tarefaConcluida = getTarefa(tarefaId);
		tarefaConcluida.setStatus(Status.CONCLUIDO);
		tarefaConcluida.setDataEntrega(LocalDate.now());
		inserirTarefaNoDB(tarefaConcluida);
	}

	private void inserirTarefaNoDB(Tarefa tarefa) {
		String tarefaId = tarefa.getId();
			try {
				BufferedReader br = atf.getBr();
			} catch (IOException e) {
				e.printStackTrace();
			}

		List<Tarefa> tarefas = getTarefas();
		String[] dbAtualizado = new String[tarefas.size()];
		
		//Montando o banco de dados para substituir o antigo
		for (int i = 0 ; i < tarefas.size() ; i++) {
			Tarefa tarefaTemp = tarefas.get(i);
			if (tarefaTemp.getId().equals(tarefaId)) {
				dbAtualizado[i] = tarefa.toString();
			}
			else {
				dbAtualizado[i] = tarefaTemp.toString();
			}
		}

		try {
			BufferedWriter bw = atf.getDbBW();
			bw.write(simplificarDB(dbAtualizado));
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String simplificarDB(String[] dbAtualizado) {
		String dbSimplificado ="";
		for (int i = 0 ; i < dbAtualizado.length; i++){
			dbSimplificado+= dbAtualizado[i];
		}
		return dbSimplificado;
	}
}

package br.dev.edvan.gerenciador_tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import br.dev.edvan.gerenciador_tarefas.model.Funcionario;
import br.dev.edvan.gerenciador_tarefas.model.Status;
import br.dev.edvan.gerenciador_tarefas.model.Tarefa;


public class Main {
	public static void main(String[] args) {
		
//		testarLeituraEscritaArquivo();
		
		Funcionario funcionario = new Funcionario("Juninho");
		Tarefa tarefa = new Tarefa(funcionario);
		tarefa.setNome("Lavar a louça");
		tarefa.setDescricao("Lavar a louça antes de eu chegar");
		tarefa.setDataInicio(LocalDate.of(2025, 5, 21));
		tarefa.setPrazo(1);
		tarefa.setStatus(Status.EM_ANDAMENTO);


	}

	private static void testarLeituraEscritaArquivo() {
		String so = System.getProperty("os.name");
		System.out.println("o seu sistema operacional é o " + so); 
		//não tá incluso no código, mas é isso que vai decidir a estrutura de caminho que vamos usar, se for botar um if else num update futuro

		String path = "/Users/25132698/projetoTarefas/tarefas";
		FileReader fileReader = null;
		BufferedReader bufferReader = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferWriter = null;

		try {
			fileReader = new FileReader(path);
			bufferReader = new BufferedReader(fileReader);

			fileWriter = new FileWriter(path, true);
			bufferWriter = new BufferedWriter(fileWriter);

			bufferWriter.append("FlushedEmoji\n");
			bufferWriter.flush();

			String linha = bufferReader.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = bufferReader.readLine();
			}

		} catch (FileNotFoundException exception) {
			System.out.println("Error 404 - File not found");
		} catch (IOException exception) {
			System.out.println("Erro - Falha de leitura");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			// TODO: handle exception
		}
	}

}

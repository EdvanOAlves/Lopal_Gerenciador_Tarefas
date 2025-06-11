package br.dev.edvan.gerenciador_tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import br.dev.edvan.gerenciador_tarefas.dao.FuncionarioDAO;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;
import br.dev.edvan.gerenciador_tarefas.model.Status;
import br.dev.edvan.gerenciador_tarefas.model.Tarefa;
import br.dev.edvan.gerenciador_tarefas.ui.FuncionarioFrame;
import br.dev.edvan.gerenciador_tarefas.ui.FuncionarioListaFrame;
import br.dev.edvan.gerenciador_tarefas.ui.StarterFrame;
import br.dev.edvan.gerenciador_tarefas.utils.Utils;


public class Main {
	public static void main(String[] args) {


		new StarterFrame();
		
//		FuncionarioDAO dao = new FuncionarioDAO(null);
//		dao.getFuncionarios();
//		
//		
//		new FuncionarioListaFrame();		

//		new FuncionarioFrame();
		
//		testarLeituraEscritaArquivo();
		
//		Funcionario funcionario = new Funcionario("Juninho");
//		funcionario.setSetor("Tecnologia da Informação");
//		funcionario.setSalario(6942.00);
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
		
//		Tarefa tarefa = new Tarefa(funcionario);
//		tarefa.setNome("Lavar a louça");
//		tarefa.setDescricao("Lavar a louça antes de eu chegar");
//		tarefa.setDataInicio(LocalDate.of(2025, 5, 21));
//		tarefa.setPrazo(1);
//		tarefa.setStatus(Status.EM_ANDAMENTO);
//
//
//		System.out.println(Utils.gerarUUID8());
//		System.out.println(funcionario);

	}
	
	//codigo de introducao a um filewriter, vou manter aqui para referencia

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

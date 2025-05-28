package br.dev.edvan.gerenciador_tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoFuncionarioFactory {
	
	private String caminho = "/Users/25132698/projetoTarefas/funcionarios.csv";
	private FileWriter fw;
	private BufferedWriter bw;
	
	public BufferedWriter getBw() throws IOException {
		
		fw = new FileWriter(caminho, true);//ditando o caminho e avisando o programa que vai ser append true
		bw = new BufferedWriter(fw);
		
		return bw;
	}
	
}

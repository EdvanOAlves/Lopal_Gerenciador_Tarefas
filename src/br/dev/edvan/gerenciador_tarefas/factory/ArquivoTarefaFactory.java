package br.dev.edvan.gerenciador_tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTarefaFactory {
	private String caminho = "data/tarefas.csv";
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	public BufferedWriter getBw() throws IOException {
		
		fw = new FileWriter(caminho, true);//ditando o caminho e avisando o programa que vai ser append true
		bw = new BufferedWriter(fw);
		
		return bw;
	}
	
	public BufferedReader getBr() throws FileNotFoundException {
		
		fr = new FileReader(caminho);
		br = new BufferedReader(fr);
		return br;
		
	}

	public BufferedWriter getDbBW() throws IOException{
		fw = new FileWriter(caminho, false);//ditando o caminho e avisando o programa que vai ser append true
		bw = new BufferedWriter(fw);
		
		return bw;
	}
}

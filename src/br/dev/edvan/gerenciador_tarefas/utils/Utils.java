package br.dev.edvan.gerenciador_tarefas.utils;

import java.util.UUID;

public class Utils {
	
	public static String gerarUUID8(){
		
		UUID uuid = UUID.randomUUID();
		
		String uuid8 = uuid.toString().substring(0, 8);
		
		return uuid8;
	}

}

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
		
		/*
		 * TODO: 
		 * 
		 * 
		 *								Lidar adequadamente com as exceções:
		 * 		Exceções que quebram o software, precisando de manutenção nos arquivos csv:
		 * 
		 * De ambos os formulários
		 * - Campos vazios nos inputs
		 * 
		 * De tarefas
		 * - Datas inválidas
		 * 
		 * 	BUGS: Coisas que não quebram o programa, mas que geram resultados estranhos, então impedir o usuário de fazer isso
		 *
		 *								Funcionalidades
		 *
		 *Extras: que não foram solicitadas
		 * - Apagar Funcionários ou tarefas
		 * - Acessar o frame de formulário depois da criação, migrar o Concluir tarefa pra lá, encaixa mais
		 * - hasComma() é uma verificacão bem manual das variáveis, funciona, mas poderia ser um método estático em utils que recebe o toString() daquele  objeto e faz uma verificação melhor das vírgulas
		 *
		 * 
		 */
		
		

	}
	
	

}

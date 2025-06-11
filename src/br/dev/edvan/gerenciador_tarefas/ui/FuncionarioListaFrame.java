package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.edvan.gerenciador_tarefas.dao.FuncionarioDAO;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;

public class FuncionarioListaFrame {

	private JLabel labelTitulo;
	private JButton btnNovo;

	private DefaultTableModel model; // dados da tabela
	private JTable tabelaFuncionarios; // tabela visualmente
	private JScrollPane scrollFuncionarios; // Container da tabela

	String[] colunas = { "CÓDIGO", "NOME FUNCIONÁRIO", "CARGO" };

	public FuncionarioListaFrame() {
		criarTela();
	}

	private void criarTela() {
		JFrame telaFuncionarioLista = new JFrame("Lista de funcionários");
		telaFuncionarioLista.setSize(700, 500);
		telaFuncionarioLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaFuncionarioLista.setLayout(null);
		telaFuncionarioLista.setLocationRelativeTo(null);
		telaFuncionarioLista.setResizable(false);

		Container painel = telaFuncionarioLista.getContentPane();

		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);

		// Criando tabela
		model = new DefaultTableModel(colunas, 100);
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);
		carregarDadosTabela();

		painel.add(scrollFuncionarios);
		painel.add(labelTitulo);

		telaFuncionarioLista.setVisible(true);

	}

	private void carregarDadosTabela() {
		List<Funcionario> funcionarios = new ArrayList<>();
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();
		
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int i = 0;
		for(Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula()/*.toUpperCase()*/;
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		model.setDataVector(dados, colunas);
	}

}

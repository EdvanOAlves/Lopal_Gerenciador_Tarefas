package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefaListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnNovaTarefa;
	
	private DefaultTableModel model; //dados da tabela
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	
	public TarefaListaFrame(JFrame parentFrame){
		criarTela(parentFrame);
		
	}
	
	private void criarTela(JFrame parentFrame) {
		//Configuração inicial da janela
		JDialog telaTarefaLista = new JDialog(parentFrame, "Lista de tarefas");
		telaTarefaLista.setSize(700, 500);
		telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefaLista.setLayout(null);
		telaTarefaLista.setLocationRelativeTo(null);
		telaTarefaLista.setResizable(false);
		
		Container painel = telaTarefaLista.getContentPane();
		
		//Elementos da janela
		labelTitulo = new JLabel("Registro de Tarefas");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);
		
		//Criando Tabela 
//		model = new DefaultTableModel(colunas, 100);
//		tabelaFuncionarios = new JTable(model);
//		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
//		scrollFuncionarios.setBounds(10, 70, 680, 300);
//		carregarDadosTabela();
		
		btnNovaTarefa = new JButton("Registrar nova tarefa");
		btnNovaTarefa.setBounds(440, 380, 250, 50);
		
		painel.add(scrollTarefas);
		painel.add(labelTitulo);
		painel.add(btnNovaTarefa);
		
		telaTarefaLista.setVisible(true);
		btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TarefaFrame(telaTarefaLista);
				carregarDadosTabela();
				
			}
		});
		
	}
	private void carregarDadosTabela() {
		
	}
}

package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StarterFrame {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public StarterFrame() {
		criarTela();
	}

	private void criarTela() {
		JFrame telaMainFrame = new JFrame("Gerenciador de tarefas");
		
		telaMainFrame.setSize(300, 100);
		telaMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMainFrame.setLayout(null);
		telaMainFrame.setLocationRelativeTo(null);
		telaMainFrame.setResizable(false);
		
		Container painel = telaMainFrame.getContentPane();
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(20, 20, 120, 40);
		
		btnTarefas = new JButton ("Tarefas");
		btnTarefas.setBounds(150, 20, 120, 40);
		
		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);	
		
		telaMainFrame.setVisible(true);
		
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioListaFrame(telaMainFrame);
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaListaFrame(telaMainFrame);
				
			}
		});
	}
}

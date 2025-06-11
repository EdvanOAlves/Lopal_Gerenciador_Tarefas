package br.dev.edvan.gerenciador_tarefas.ui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaFrame {
	private JLabel labelId;
	private JLabel labelNomeTarefa;
	private JLabel labelDescricao;
	private JLabel labelResponsavel;
	private JLabel labelDataDeInicio;
	private JLabel labelPrazo;
	private JLabel labelDataEntrega;
	
	private JTextField txtId;
	private JTextField txtNomeTarefa;
	private JTextField txtDescricao;
	private JTextField txtResponsavel;
	private JTextField txtDataDeInicio;
	private JTextField txtPrazo;
	private JTextField txtDataEntrega;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	
	public TarefaFrame(JDialog parentFrame) {
		criarTela(parentFrame);
		
	}
	
	private void criarTela(JDialog parentFrame) {
		JDialog telaTarefa = new JDialog(parentFrame, "Registrar nova tarefa");
		
		telaTarefa.setSize(500, 500);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setLayout(null);
		telaTarefa.setResizable(false);
		telaTarefa.setLocationRelativeTo(null);
	}

}

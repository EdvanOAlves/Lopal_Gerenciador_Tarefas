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
		//TODO: A propria tabela que vai servir de lista
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
		
		scrollTarefas = new JScrollPane();
		scrollTarefas.setBounds(10, 70, 665, 300);
		
		//Criando Tabela TODO: adaptar esse trecho de código usando o de funcionario como base
//		model = new DefaultTableModel(colunas, 100);
//		tabelaFuncionarios = new JTable(model);
//		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
//		scrollFuncionarios.setBounds(10, 70, 680, 300);
//		carregarDadosTabela();
		
		btnNovaTarefa = new JButton("Registrar nova tarefa");
		btnNovaTarefa.setBounds(440, 380, 235, 50);
		
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
	private void carregarDadosTabela() { //TODO: Adaptar esse metodo usando o de funcionario como base
//		List<Funcionario> funcionarios = new ArrayList<>();
//		
//		FuncionarioDAO dao = new FuncionarioDAO(null);
//		funcionarios = dao.getFuncionarios();
//		
//		Object[][] dados = new Object[funcionarios.size()][3];
//		
//		int i = 0;
//		for(Funcionario f : funcionarios) {
//			dados[i][0] = f.getMatricula()/*.toUpperCase()*/;
//			dados[i][1] = f.getNome();
//			dados[i][2] = f.getCargo();
//			i++;
//		}
//		model.setDataVector(dados, colunas);
//	}
		
	}
}

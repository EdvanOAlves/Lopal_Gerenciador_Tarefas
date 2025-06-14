package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.edvan.gerenciador_tarefas.dao.TarefaDAO;
import br.dev.edvan.gerenciador_tarefas.model.Status;
import br.dev.edvan.gerenciador_tarefas.model.Tarefa;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton btnNovaTarefa;

	private DefaultTableModel model; // dados da tabela
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;

	String[] colunas = { "ID", "TAREFA", "DESCRIÇÃO", "RESPONSÁVEL", "STATUS" };

	public TarefaListaFrame(JFrame parentFrame) {
		criarTela(parentFrame);

	}

	private void criarTela(JFrame parentFrame) {
		// TODO: A propria tabela que vai servir de lista
		// Configuração inicial da janela
		JDialog telaTarefaLista = new JDialog(parentFrame, "Lista de tarefas");
		telaTarefaLista.setSize(690, 500);
		telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefaLista.setLayout(null);
		telaTarefaLista.setLocationRelativeTo(null);
		telaTarefaLista.setResizable(false);

		Container painel = telaTarefaLista.getContentPane();

		// Elementos da janela
		labelTitulo = new JLabel("Registro de Tarefas");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);

		scrollTarefas = new JScrollPane();
		scrollTarefas.setBounds(10, 70, 600, 300);

		// Criando Tabela
		model = new DefaultTableModel(colunas, 100);
		tabelaTarefas = new JTable(model);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 70, 650, 300);
		carregarDadosTabela();

		btnNovaTarefa = new JButton("Registrar nova tarefa");
		btnNovaTarefa.setBounds(425, 380, 235, 50);


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

	private void carregarDadosTabela() { // TODO: Adaptar esse metodo usando o de funcionario como base
		List<Tarefa> tarefas = new ArrayList<>();
		System.out.println("Foi");
		//Acessando os dados e montando uma lista
		TarefaDAO dao = new TarefaDAO(null);
		tarefas = dao.getTarefas();

		Object[][] dados = new Object[tarefas.size()][5];

		int i = 0;
		for (Tarefa tarefa : tarefas) {
			System.out.println("Foi2");
			JComboBox<Status> statusBox;
			statusBox = new JComboBox<>(new Status[]{tarefa.getStatus(), Status.CONCLUIDO});
			dados[i][0] = tarefa.getId()/* .toUpperCase() */;
			dados[i][1] = tarefa.getNome();
			dados[i][2] = tarefa.getDescricao();
			dados[i][3] = tarefa.getResponsavel().getNome();
			dados[i][4] = statusBox;
			i++;
		}
		model.setDataVector(dados, colunas);
	}

}

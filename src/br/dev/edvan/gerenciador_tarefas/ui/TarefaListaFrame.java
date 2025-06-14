package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import br.dev.edvan.gerenciador_tarefas.dao.TarefaDAO;
import br.dev.edvan.gerenciador_tarefas.model.Status;
import br.dev.edvan.gerenciador_tarefas.model.Tarefa;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton btnNovaTarefa;

	private DefaultTableModel model; // dados da tabela
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;

	String[] colunas = { "ID", "TAREFA", "DESCRIÇÃO","INÍCIO", "VENCIMENTO" , "RESPONSÁVEL", "STATUS" };

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
		model = new DefaultTableModel(colunas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 4;
			}
		};
		tabelaTarefas = new JTable(model);
		
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 70, 650, 300);
		carregarDadosTabela();
		
		//Seleção de opção para atualizar o Status (no caso marcar o concluído)
		JComboBox<Status> statusBox;
		statusBox = new JComboBox<>(Status.values());
		DefaultCellEditor editor = new DefaultCellEditor(statusBox);
		tabelaTarefas.getColumnModel().getColumn(4).setCellEditor(editor);
		// TODO: O sistema precisa reconhecer o "CONCLUIDO" quando selecionado, gravar essa atualização e 
		// registrar a data de conclusão
		// TODO: Não encontrei ainda como limitar as opções, por conta dessa configuração do ComboBox ocorrer 
		// fora do carregarDados() acaba não sendo muito viável usar um ({getStatus(), Status.CONCLUIDO}) 
		// nas opções, mas o ideal seria encontrar como fazer isso

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
		//Acessando os dados e montando uma lista
		TarefaDAO dao = new TarefaDAO(null);
		tarefas = dao.getTarefas();

		Object[][] dados = new Object[tarefas.size()][7];

		int i = 0;
		for (Tarefa tarefa : tarefas) {
			dados[i][0] = tarefa.getId()/* .toUpperCase() */;
			dados[i][1] = tarefa.getNome();
			dados[i][2] = tarefa.getDescricao();
			dados[i][3] = tarefa.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			dados[i][4] = tarefa.getDataPrazo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			dados[i][5] = tarefa.getResponsavel().getNome();
			dados[i][6] = tarefa.getStatus();
			i++;
		}
		model.setDataVector(dados, colunas);
	}

}

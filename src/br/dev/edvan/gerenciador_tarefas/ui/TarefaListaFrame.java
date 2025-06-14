package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
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

	Container painel;

	String[] colunas = { "ID", "TAREFA", "DESCRIÇÃO", "INÍCIO", "VENCIMENTO", "RESPONSÁVEL", "STATUS" };
	private JButton[] btnsConcluir;

	Rectangle referenciaBtnConcluir = new Rectangle(600, 90, 40, 17);

	TarefaDAO dao;

	public TarefaListaFrame(JFrame parentFrame) {
		criarTela(parentFrame);

	}

	private void criarTela(JFrame parentFrame) {
		// TODO: A propria tabela que vai servir de lista
		// Configuração inicial da janela
		JDialog telaTarefaLista = new JDialog(parentFrame, "Lista de tarefas", true);
		telaTarefaLista.setSize(750, 500);
		telaTarefaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefaLista.setLayout(null);
		telaTarefaLista.setLocationRelativeTo(null);
		telaTarefaLista.setResizable(false);

		painel = telaTarefaLista.getContentPane();

		// Elementos da janela
		labelTitulo = new JLabel("Registro de Tarefas");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.RED);

		scrollTarefas = new JScrollPane();
		scrollTarefas.setBounds(10, 70, 600, 300);

		// Criando Tabela
		model = new DefaultTableModel(colunas, 0);
		tabelaTarefas = new JTable(model);

		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 70, 650, 300);
		carregarDadosTabela();

		btnNovaTarefa = new JButton("Registrar nova tarefa");
		btnNovaTarefa.setBounds(425, 380, 235, 50);

		painel.add(scrollTarefas);
		painel.add(labelTitulo);
		painel.add(btnNovaTarefa);


		btnNovaTarefa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TarefaFrame(telaTarefaLista);
				carregarDadosTabela();
			}
		});

		telaTarefaLista.setVisible(true);
	}

	private void carregarDadosTabela() {
		List<Tarefa> tarefas = new ArrayList<>();
		// Acessando os dados e montando uma lista
		dao = new TarefaDAO(null);
		tarefas = dao.getTarefas();
		Object[][] dados = new Object[tarefas.size()][7];
		btnsConcluir = new JButton[tarefas.size()];

		int i = 0;
		for (Tarefa tarefa : tarefas) {
			dados[i][0] = tarefa.getId()/* .toUpperCase() */;
			dados[i][1] = tarefa.getNome();
			dados[i][2] = tarefa.getDescricao();
			dados[i][3] = tarefa.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			dados[i][4] = tarefa.getDataPrazo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			dados[i][5] = tarefa.getResponsavel().getNome();
			dados[i][6] = tarefa.getStatus();

			btnsConcluir[i] = criarBtnConcluir(i, tarefa.getId(), tarefa.getNome());

			i++;
		}
		model.setDataVector(dados, colunas);
		addElements(btnsConcluir);
		


	}

	// Função para criar um botão para conclusão de tarefa com posicionamento e
	// funcionalidade sendo configurados automaticamente
	private JButton criarBtnConcluir(int i, String tarefaId, String tarefaNome) {
		JButton buttonConcluir = new JButton("...");
		int y = 90 + (16 * i);
		
		buttonConcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tabelaTarefas, "Tarefa: "+tarefaId +" - "+ tarefaNome +"\nConcluir tarefa?", "Atenção" ,JOptionPane.YES_NO_OPTION);
				if (resposta == 0) {	
					dao.concluirTarefa(tarefaId);
					carregarDadosTabela();
				}
				
			}
		});

		referenciaBtnConcluir.setLocation(660, y);
		buttonConcluir.setBounds(referenciaBtnConcluir);
		// TODO Auto-generated method stub
		return buttonConcluir;
	}

	// Função para adicionar elementos no painel usando array
	private void addElements(Component[] elements) {
		for (Component element : elements) {
			painel.add(element);
		}
	}

}

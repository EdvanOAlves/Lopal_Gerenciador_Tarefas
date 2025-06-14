package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.dev.edvan.gerenciador_tarefas.dao.FuncionarioDAO;
import br.dev.edvan.gerenciador_tarefas.dao.TarefaDAO;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;
import br.dev.edvan.gerenciador_tarefas.model.Tarefa;
import br.dev.edvan.gerenciador_tarefas.utils.Utils;

public class TarefaFrame {
	private JLabel labelId;
	private JLabel labelNomeTarefa;
	private JLabel labelDescricao;
	private JLabel labelResponsavel;
	private JLabel labelDataInicio;
	private JLabel labelPrazo;
	private JLabel labelDataPrazo;
	private JLabel labelStatus;

	private JTextField txtId;
	private JTextField txtNomeTarefa;
	private JTextField txtDescricao;
	private JComboBox<String> comboBoxResponsavel;
	private JTextField txtDataInicio;
	private JTextField txtPrazo;
	private JTextField txtDataPrazo;
//	private JComboBox<E> comboStatus;

	private JButton btnSalvar;
	private JButton btnSair;

	public TarefaFrame(JDialog parentFrame) {
		criarTela(parentFrame);

	}

	private void criarTela(JDialog parentFrame) {
		JDialog telaTarefa = new JDialog(parentFrame, "Registrar nova tarefa");

		telaTarefa.setSize(410, 500);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setLayout(null);
		telaTarefa.setResizable(false);
		telaTarefa.setLocationRelativeTo(null);

		Container painel = telaTarefa.getContentPane();

		// Elementos da tela e posicionamento
		labelId = new JLabel("ID da tarefa:");
		labelId.setBounds(10, 10, 150, 30);
		txtId = new JTextField();
		txtId.setBounds(10, 35, 150, 30);
		txtId.setEnabled(false);
		txtId.setText(Utils.gerarUUID8());

		labelNomeTarefa = new JLabel("Nome:");
		labelNomeTarefa.setBounds(10, 65, 150, 30);
		txtNomeTarefa = new JTextField();
		txtNomeTarefa.setBounds(10, 90, 250, 30);

		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 120, 150, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 145, 250, 30);

		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 175, 150, 30);
		comboBoxResponsavel = new JComboBox<>(getFuncionariosNomes());
		comboBoxResponsavel.setBounds(10, 200, 200, 30);
		// TODO: Funcionalidade de ComboBox

		labelDataInicio = new JLabel("Data de início:");
		labelDataInicio.setBounds(10, 230, 100, 30);
		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(10, 255, 100, 30);

		labelPrazo = new JLabel("Prazo(dias):");
		labelPrazo.setBounds(10, 285, 100, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 310, 100, 30);

		labelDataPrazo = new JLabel("Data de entrega:");
		labelDataPrazo.setBounds(10, 340, 100, 30);
		txtDataPrazo = new JTextField();
		txtDataPrazo.setBounds(10, 365, 100, 30);
		txtDataPrazo.setEditable(false);
		// TODO: Calculo de data com a data de início e o prazo

		labelStatus = new JLabel("Status");
		labelStatus.setBounds(310, 230, 100, 30);
//		comboStatus = new JComboBox<E>();
//		comboStatus.setBound(310, 255, 100, 30);

		btnSair = new JButton("Sair");
		btnSair.setBounds(10, 410, 120, 40);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(260, 410, 120, 40);
//				btnSalvar.setOpaque(true);
//				btnSalvar.setBackground(Color.GREEN);

		painel.add(labelId);
		painel.add(txtId);
		painel.add(labelNomeTarefa);
		painel.add(txtNomeTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelResponsavel);
		painel.add(comboBoxResponsavel); // TODO: Funcionalidade de ComboBox
		painel.add(labelDataInicio);
		painel.add(txtDataInicio);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataPrazo);
		painel.add(txtDataPrazo);
		painel.add(labelStatus);
//		painel.add(comboBoxStatus);

		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		
		DocumentListener listener = new DocumentListener() {//Calculo de previsão de entrega
			
			@Override
			public void removeUpdate(DocumentEvent e) {
						
			}			
			@Override
			public void insertUpdate(DocumentEvent e) {
				atualizarDataPrevista();				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarDataPrevista();		
			}
			
			private void atualizarDataPrevista() {
				String dataTxt = txtDataInicio.getText();
				String prazoTxt = txtPrazo.getText();
				try {
					dataTxt = dataTxt.replace('/', '-'); //Tratamento de input, dessa forma posso consultar do arquivo e do input usando o mesmo método
					LocalDate data = LocalDate.parse(dataTxt, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					//TODO: esse formato funciona, mas acaba barrando input de "d/M/yyyy" que também deveria funcionar, ajustar depois
					int prazo = Integer.parseInt(prazoTxt);
					LocalDate dataPrevista = (LocalDate) data.plusDays(prazo);
					
					txtDataPrazo.setText(dataPrevista.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				} 
				catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		
		txtDataInicio.getDocument().addDocumentListener(listener);
		txtPrazo.getDocument().addDocumentListener(listener);

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Reorganizar isso aqui
				int responsavelIndex = comboBoxResponsavel.getSelectedIndex();
				Funcionario funcionario = getFuncionario(findMatricula(responsavelIndex));
				
	
				// Montando a tarefa
				Tarefa tarefa = new Tarefa(funcionario);
				tarefa.setId(txtId.getText());
				tarefa.setNome(txtNomeTarefa.getText());
				tarefa.setDescricao(txtDescricao.getText());
				tarefa.setDataInicio(txtDataInicio.getText());
				tarefa.setPrazo(Integer.parseInt(txtPrazo.getText()));
//				tarefa.setDataEntrega(txtDataEntrega.getText()); //TODO: Calculo de data de entrega
				tarefa.getStatus();	
				//TODO: Status vai se atualizar com a data de início e o prazo, não vai ter input de fato
				//Ou... Vamos poder abrir uma tarefa pela ListaTarefas para marcar ela como concluida?

				// Salvando nossa tarefa
				TarefaDAO dao = new TarefaDAO(tarefa);
				boolean success = dao.gravar();

				// Feedback para o usario
				if (success) {
					JOptionPane.showMessageDialog(telaTarefa, "Tarefa atribuída com sucesso!");
					limparFormulario();
				} else {
					JOptionPane.showMessageDialog(telaTarefa,
							"Ocorreu um erro na gravação\nTente novamente.\nSe o problema persistir, entre em contato com o suporte.");
				}
			}
		});

		// confirmacao e funcionalidade do botão sair
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaTarefa, "Sair do sistema?", "Atenção",
						JOptionPane.YES_NO_OPTION);
				if (resposta == 0) {
					telaTarefa.dispose();
				}

			}
		});

		telaTarefa.setVisible(true);

	}

	private void limparFormulario() {

	}

	// Brainstorm para resolver o assign de responsável:
	// TODO: Otimizar isso tudo, talvez migrar para outras classes
	private Object[][] listarFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();

		// Acessando os dados e montando uma lista
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();

		Object[][] dados = new Object[funcionarios.size()][2];

		int i = 0;
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula()/* .toUpperCase() */;
			dados[i][1] = f.getNome();
			i++;
		}
		return dados;
	}

	private String[] getFuncionariosNomes() {
		Object[][] dados = listarFuncionarios();

		String[] funcionariosNomes = new String[dados.length];

		for (int i = 0; i < funcionariosNomes.length; i++) {
			funcionariosNomes[i] = (String) dados[i][1];
		}
		return funcionariosNomes;
	}

	private String findMatricula(int responsavelIndex) {
		Object[][] dados = listarFuncionarios(); 
		String matricula = (String) dados[responsavelIndex][0];
		return matricula;
	}
	
	private Funcionario getFuncionario(String matricula) {
		List<Funcionario> funcionarios = new ArrayList<>();
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();
		
		String matriculaTemp;
		Funcionario funcionario = null;
		
		for (int i = 0 ; i < funcionarios.size(); i++) {
			funcionario = funcionarios.get(i);
			matriculaTemp = funcionarios.get(i).getMatricula();
			if (matriculaTemp.equals(matricula)) {
				return funcionario;
			}
		}
		return funcionario;
	}

}

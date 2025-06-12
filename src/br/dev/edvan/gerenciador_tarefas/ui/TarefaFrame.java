package br.dev.edvan.gerenciador_tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.edvan.gerenciador_tarefas.dao.FuncionarioDAO;
import br.dev.edvan.gerenciador_tarefas.model.Funcionario;
import br.dev.edvan.gerenciador_tarefas.utils.Utils;

public class TarefaFrame {
	private JLabel labelId;
	private JLabel labelNomeTarefa;
	private JLabel labelDescricao;
	private JLabel labelResponsavel;
	private JLabel labelDataInicio;
	private JLabel labelPrazo;
	private JLabel labelDataDeEntrega;

	private JTextField txtId;
	private JTextField txtNomeTarefa;
	private JTextField txtDescricao;
//	private JComboBox<E> comboBoxResponsavel;
	private JTextField txtDataInicio;
	private JTextField txtPrazo;
	private JTextField txtDataEntrega;

	private JButton btnSalvar;
	private JButton btnSair;

	public TarefaFrame(JDialog parentFrame){
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
		labelId.setBounds(10, 20, 150, 30);
		txtId = new JTextField();
		txtId.setBounds(10, 50, 150, 30);
		txtId.setEnabled(false);
		txtId.setText(Utils.gerarUUID8());

		labelNomeTarefa = new JLabel("Nome:");
		labelNomeTarefa.setBounds(10, 85, 150, 30);
		txtNomeTarefa = new JTextField();
		txtNomeTarefa.setBounds(10, 115, 250, 30);

		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 150, 150, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 180, 250, 30);
		
		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(10, 215, 150, 30);
//		comboBoxResponsavel = new JComboBox<E>();
//		comboBoxResponsavel.setBounds(10, 245, 200, 30);
		//TODO: Funcionalidade de ComboBox

		labelDataInicio = new JLabel("Data de início:");
		labelDataInicio.setBounds(280, 150, 100, 30);
		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(280, 180, 100, 30);
		
		labelPrazo = new JLabel("Prazo(dias):");
		labelPrazo.setBounds(280, 215, 100, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(280, 245, 100, 30);
		
		labelDataDeEntrega = new JLabel("Data de entrega:");
		labelDataDeEntrega.setBounds(280, 280, 100, 30);
		txtDataEntrega = new JTextField();
		txtDataEntrega.setEnabled(false);
		txtDataEntrega.setBounds(280, 315, 100, 30);
		//TODO: Calculo de data com a data de início e o prazo
		

		btnSair = new JButton("Sair"); //Redefinir isso
		btnSair.setBounds(10, 380, 120, 40);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(260, 380, 120, 40);// Redefeinir isso
//				btnSalvar.setOpaque(true);
//				btnSalvar.setBackground(Color.GREEN);


		painel.add(labelId);
		painel.add(txtId);
		painel.add(labelNomeTarefa);
		painel.add(txtNomeTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelResponsavel);
//		painel.add(comboBoxResponsavel); TODO: Funcionalidade de ComboBox
		painel.add(labelDataInicio);
		painel.add(txtDataInicio);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataDeEntrega);
		painel.add(txtDataEntrega);
		
		painel.add(btnSalvar);
		painel.add(btnSair);

		// TODO: funcionalidade do botão de Salvar

//				//
//				/* COPYPASTA */
//				//
//		btnSalvar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				
//				// Montando um modelo de funcionario
//				Funcionario f = new Funcionario(txtNome.getText());
//				f.setMatricula(txtMatricula.getText());
//				f.setCargo(txtCargo.getText());
//				f.setSetor(txtSetor.getText());
//				double salario = Double.parseDouble(txtSalario.getText());
//				f.setSalario(salario);
//
//				// Fazendo Funcionario salvar
//				FuncionarioDAO dao = new FuncionarioDAO(f);
//				boolean success = dao.gravar();
//
//				// Feedback para o usario
//				if (success) {
//					JOptionPane.showMessageDialog(telaFuncionario, "Funcionário cadastrado com sucesso!");
//					limparFormulario();
//				} else {
//					JOptionPane.showMessageDialog(telaFuncionario,
//							"Ocorreu um erro na gravação\nTente novamente.\nSe o problema persistir, entre em contato com o suporte.");
//
//				}
//			}
//		});
		//
		/* COPYPASTA */
		//

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

}


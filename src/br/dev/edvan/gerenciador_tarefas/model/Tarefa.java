package br.dev.edvan.gerenciador_tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.dev.edvan.gerenciador_tarefas.utils.Utils;

public class Tarefa {
	private String id;
	private String nome;
	private String descricao;
	private Funcionario responsavel;
	private LocalDate dataInicio;
	private int prazo;
	private LocalDate dataEntrega;
	private Status status;
	private String txtDataInicio;

	public Tarefa(Funcionario funcionario) {
		// TODO Auto-generated constructor stub
		setId(Utils.gerarUUID8());
		setResponsavel(funcionario);
	}

	// Gets e Sets

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataTxt) {
		this.dataInicio = LocalDate.parse(dataTxt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		txtDataInicio = dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); //Eu poderia fazer isso no toString ou aqui com uma variável, preferi fazer aqui
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrazo() {
		//TODO: Poderia incluir esse método num util, o formulário de tarefa também faz algo igual 
		LocalDate dataPrazo = dataInicio.plusDays(prazo);
		return dataPrazo;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String string) {
//		this.dataEntrega = string; TODO: Método para gravar a data de conclusão, usado no TarefaListaFrame quando marcam o "Concluído"
	}

	public Status getStatus() {
		calcStatus();
		return status;
	}


	private void calcStatus() { 
		LocalDate dataPrazo = getDataPrazo();
		LocalDate hoje = LocalDate.now();
		if (hoje.isBefore(dataInicio)) {
			setStatus(Status.NAO_INICIADO);

		}
		if (hoje.isBefore(dataPrazo)) {
			setStatus(Status.EM_ANDAMENTO);
		} else if (hoje.isAfter(dataPrazo)) {
			setStatus(Status.EM_ATRASO);
		}
	}

	private void setStatus(Status status) {
		this.status = status;
	}

	public void updateStatus(Status status) {
		//TODO: Inserir método para concluir a tarefa

	}

	@Override
	public String toString() {
		String matricula = responsavel.getMatricula();
		String responsavelNome = responsavel.getNome();
		return 
				id+","+nome+","+descricao+","+matricula+","+responsavelNome+","+txtDataInicio+","+prazo+","+dataEntrega + "\n"; 
	}

}

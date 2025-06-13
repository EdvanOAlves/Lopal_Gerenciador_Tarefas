package br.dev.edvan.gerenciador_tarefas.model;

import java.time.LocalDate;

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

	public void setDataInicio(String dataText) { //TODO: Fazer a devida conversão do String recebido para
		String[] splitData= dataText.split("/");
		int dataAno = Integer.parseInt(splitData[2]);
		int dataMes = Integer.parseInt(splitData[1]);
		int dataDia = Integer.parseInt(splitData[0]);
		LocalDate data = LocalDate.of(dataAno, dataMes, dataDia);
		this.dataInicio = data;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataInicio.plusDays(prazo);

	}


	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() { //TODO: Integrar o status com a classe Status
		LocalDate dataPrevistaEntrega = getDataPrevistaEntrega();
		LocalDate hoje = LocalDate.now();
		if (hoje.isBefore(dataPrevistaEntrega)) {
		}
		else if (hoje.isAfter(dataPrevistaEntrega));
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}

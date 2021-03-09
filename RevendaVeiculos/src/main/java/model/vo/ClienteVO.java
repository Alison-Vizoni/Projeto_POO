package model.vo;

import java.time.LocalDate;

public class ClienteVO {
	
	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dtNascimento;
	
	public ClienteVO(int idCliente, String nome, String cpf, String telefone, LocalDate dtNascimento) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
	}

	public ClienteVO() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public void imprimir() {
		System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-10s\n",
				this.getIdCliente(),
				this.getNome(),
				this.getCpf(),
				this.getTelefone(),
				this.getDtNascimento());
	}

}

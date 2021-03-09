package model.dto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VendasDTO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DecimalFormat df = new DecimalFormat("0.00");
	
	private String nome;
	private String cpf;
	private String telefone;
	private String modelo;
	private String placa;
	private LocalDate dataVenda;
	private double valorVenda;
	
	public VendasDTO(String nome, String cpf, String telefone, String modelo, String placa, LocalDate dataVenda,
			double valorVenda) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.modelo = modelo;
		this.placa = placa;
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
	}

	public VendasDTO() {
		super();
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public void imprimir() {
		System.out.printf("\n%10s   %-10s   %-10s   %-10s   %-10s   %-10s   %-10s\n",
				this.getNome(),
				this.getCpf(),
				this.getTelefone(),
				this.getModelo(), 
				this.getPlaca(),
				this.getDataVenda(),
				this.getValorVenda());
	}

}

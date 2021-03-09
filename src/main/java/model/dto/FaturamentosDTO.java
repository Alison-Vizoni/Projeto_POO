package model.dto;

public class FaturamentosDTO {
	
	private int mes;	
	private int ano;
	private double totalVendas;
	
	public FaturamentosDTO(int mes, int ano, double totalVendas) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.totalVendas = totalVendas;
	}

	public FaturamentosDTO() {
		super();
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	public void imprimir() {
		System.out.printf("\n%10d   %-10d   %-10s\n",
				this.getMes(),
				this.getAno(),
				this.getTotalVendas());
	}
}

package model.vo;

public class VeiculoVO {

	private int idveiculo;
	private String modelo;
	private TipoVeiculo tipo;
	private String fabricante;
	private int ano;
	private String cor;
	private String placa;
	
	public VeiculoVO(int idveiculo, String modelo, TipoVeiculo tipo, String fabricante, int ano, String cor,
			String placa) {
		super();
		this.idveiculo = idveiculo;
		this.modelo = modelo;
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.ano = ano;
		this.cor = cor;
		this.placa = placa;
	}

	public VeiculoVO() {
		super();
	}

	public int getIdveiculo() {
		return idveiculo;
	}

	public void setIdveiculo(int idveiculo) {
		this.idveiculo = idveiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void imprimir() {
		System.out.printf("\n%3d   %-10s   %-10s   %-10s   %-5d   %-10s   %-10s ",
				this.getIdveiculo(),
				this.getModelo(),
				this.getTipo(),
				this.getFabricante(),
				this.getAno(),
				this.getCor(),
				this.getPlaca());
	}
	
}

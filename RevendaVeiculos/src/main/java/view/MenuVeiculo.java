package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraVeiculo;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class MenuVeiculo {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_CADASTRAR_VEICULO = 1;
	private static final int OPCAO_ALTERAR_VEICULO = 2;
	private static final int OPCAO_RELATORIO_VEICULO = 3;
	private static final int OPCAO_EXCLUIR_VEICULO = 4;
	private static final int OPCAO_VOLTAR_MENU = 5;
	
	private static final int OPCAO_VEICULO_CARRO = 1;
	private static final int OPCAO_VEICULO_MOTO = 2;
	private static final int OPCAO_VEICULO_SUV = 3;
	private static final int OPCAO_VEICULO_FIM = 99;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_VEICULOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_VEICULOS = 2;
	private static final int OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR = 3;
	
	public void apresentarMenuVeiculo() {
		int opcao = this.manterVeiculo();
		
		while(opcao != OPCAO_VOLTAR_MENU) {
			switch (opcao) {
				case OPCAO_CADASTRAR_VEICULO: {
					this.cadastrarVeiculo();
					break;
				}
				case OPCAO_ALTERAR_VEICULO: {
					this.alterarVeiculo();
					break;
				}
				case OPCAO_RELATORIO_VEICULO: {
					this.consultarVeiculo();
					break;
				}
				case OPCAO_EXCLUIR_VEICULO: {
					this.excluirVeiculo();
					break;
				}
				default: {
					System.out.println("\nOpção inválida!");
				}
			}
			opcao = this.manterVeiculo();
		}
	}

	private int manterVeiculo() {
		System.out.println("\nMenu Veículo:\n");
		System.out.println(OPCAO_CADASTRAR_VEICULO + " - Inserir veículo");
		System.out.println(OPCAO_ALTERAR_VEICULO + " - Alterar veículo");
		System.out.println(OPCAO_RELATORIO_VEICULO + " - Relatório de veículo");
		System.out.println(OPCAO_EXCLUIR_VEICULO + " - Excluir veículo");
		System.out.println(OPCAO_VOLTAR_MENU + " - Voltar ao menu principal");
		return Integer.parseInt(teclado.nextLine());
	}

	private int apresentarOpcoesTipoVeiculo() {
		System.out.println("\nOpções:");
		System.out.println(OPCAO_VEICULO_CARRO + " - Carro");
		System.out.println(OPCAO_VEICULO_MOTO + " - Moto");
		System.out.println(OPCAO_VEICULO_SUV + " - SUV");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o modelo do veículo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.print("Digite o tipo do veículo: ");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while(opcao != OPCAO_VEICULO_FIM) {
			switch(opcao) {
			case OPCAO_VEICULO_CARRO: {
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.CARRO);
				break;
			}
			case OPCAO_VEICULO_MOTO: {
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.MOTO);
				break;
			}
			case OPCAO_VEICULO_SUV: {
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.SUV);
				break;
			}
				default: {
					System.out.println("\nOpção inválida!");
					opcao = this.apresentarOpcoesTipoVeiculo();
				}
			}
		}
		System.out.println("Digite o fabricante do veículo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.println("Digite o ano do veículo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o cor do veículo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.println("Digite a placa do veículo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.cadastrarVeiculoController(veiculoVO);
		System.out.println(resultado);
	}

	private void alterarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.println("Digite o código do veículo: ");
		veiculoVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o modelo do veículo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.print("Digite o tipo do veículo: ");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while(opcao != OPCAO_VEICULO_FIM) {
			switch(opcao) {
			case OPCAO_VEICULO_CARRO: {
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.CARRO);
				break;
			}
			case OPCAO_VEICULO_MOTO: {
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.MOTO);
				break;
			}
			case OPCAO_VEICULO_SUV: {
				opcao = OPCAO_VEICULO_FIM;
				veiculoVO.setTipo(TipoVeiculo.SUV);
				break;
			}
				default: {
					System.out.println("\nOpção inválida!");
					opcao = this.apresentarOpcoesTipoVeiculo();
				}
			}
		}
		System.out.println("Digite o fabricante do veículo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.println("Digite o ano do veículo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o cor do veículo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.println("Digite a placa do veículo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.atualizarVeiculoController(veiculoVO);
		System.out.println(resultado);
		
	}

	private void consultarVeiculo() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		while (opcao!= OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_VEICULOS:{
					opcao = OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR;
					ArrayList<VeiculoVO> listaVeiculosVO = controladoraVeiculo.consultarTodosVeiculosController();
					if (listaVeiculosVO.isEmpty()) {
						System.out.println("\nLista de veiculos não localizada");
					}
					System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s ",
							"ID", "MODELO", "TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
					for(int i=0; i < listaVeiculosVO.size(); i++) {
						listaVeiculosVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_VEICULOS:{
					opcao = OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR;
					VeiculoVO veiculoVO = new VeiculoVO();
					System.out.print("\nDigite o código do veículo: ");
					veiculoVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
					VeiculoVO veiculo = controladoraVeiculo.consultarVeiculoController(veiculoVO);
					if (veiculo == null) {
						System.out.println("\nVeiculo não localizado.");
					}
					System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s \n",
							"ID", "MODELO", "TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
					if(veiculo != null) {
						veiculo.imprimir();
					}
					break;
				}
			}
		}
	}

	private int apresentarOpcoesMenuConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada.");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_VEICULOS + " - Consultar todos os veículos");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_VEICULOS + " - Consultar um veículo específico");
		System.out.println(OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR + " - Voltar ao menu veículo");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void excluirVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o código do veículo: ");
		veiculoVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.excluirVeiculoController(veiculoVO);
		System.out.println(resultado);
	}
}

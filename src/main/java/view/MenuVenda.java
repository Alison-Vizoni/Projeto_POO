package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import controller.ControladoraVenda;
import model.vo.VendaVO;

public class MenuVenda {
	
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_REALIZAR_VENDA = 1;
	private static final int OPCAO_ALTERAR_VENDA = 2;
	private static final int OPCAO_RELATORIO_VENDA = 3;
	private static final int OPCAO_EXCLUIR_VENDA = 4;
	private static final int OPCAO_VOLTAR_MENU = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_VENDA = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_VENDA = 2;
	private static final int OPCAO_MENU_CONSULTAR_VENDA_VOLTAR = 3;
	
	public void apresentarMenuVenda() {
		int opcao = this.manterVendas();
		
		while(opcao != OPCAO_VOLTAR_MENU) {
			switch (opcao) {
				case OPCAO_REALIZAR_VENDA: {
					this.cadastrarVenda();
					break;
				}
				case OPCAO_ALTERAR_VENDA: {
					this.alterarVenda();
					break;
				}
				case OPCAO_RELATORIO_VENDA: {
					this.consultarVendas();
					break;
				}
				case OPCAO_EXCLUIR_VENDA: {
					this.excluirVenda();
					break;
				}
				default: {
					System.out.println("\nOpção inválida!");
				}
			}
			opcao = this.manterVendas();
		}
		
	}

	private int manterVendas() {
		System.out.println("\nMenu Vendas:\n");
		System.out.println(OPCAO_REALIZAR_VENDA + " - Inserir venda");
		System.out.println(OPCAO_ALTERAR_VENDA + " - Alterar venda");
		System.out.println(OPCAO_RELATORIO_VENDA + " - Relatório de vendas");
		System.out.println(OPCAO_EXCLUIR_VENDA + " - Excluir venda");
		System.out.println(OPCAO_VOLTAR_MENU + " - Voltar ao menu principal");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarVenda() {
		
		VendaVO vendaVO = new VendaVO();
		System.out.print("\nDigite o código do cliente: ");
		vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o código do veículo: ");
		vendaVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o valor da venda: ");
		vendaVO.setValorVenda(Double.parseDouble(teclado.nextLine()));
		System.out.println("Digite a data da venda: ");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.CadastrarVendaController(vendaVO);
		System.out.println(resultado);
	}

	private void alterarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.println("\nDigite o código da venda: ");
		vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o código do cliente: ");
		vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o código do veículo: ");
		vendaVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o valor da venda: ");
		vendaVO.setValorVenda(Double.parseDouble(teclado.nextLine()));
		System.out.println("Digite a data da venda: ");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.alterarVendaController(vendaVO);
		System.out.println(resultado);
		
	}

	private void consultarVendas() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		while (opcao != OPCAO_MENU_CONSULTAR_VENDA_VOLTAR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODAS_VENDA: {
					opcao = OPCAO_MENU_CONSULTAR_VENDA_VOLTAR;
					ArrayList<VendaVO> listaVendasVO = controladoraVenda.consultarTodasVendasController();
					if (listaVendasVO.isEmpty()) {
						System.out.println("\nLista de vendas não localizada");
					}
					System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-10s\n",
							"ID", "CLIENE", "VEICULO", "VALOR", "DATA");
					for(int i=0; i < listaVendasVO.size(); i++) {
						listaVendasVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UMA_VENDA: {
					opcao = OPCAO_MENU_CONSULTAR_VENDA_VOLTAR;
					VendaVO vendaVO = new VendaVO();
					System.out.print("\nDigite o código da venda: ");
					vendaVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
					VendaVO venda = controladoraVenda.consultarVendaController(vendaVO);
					if (venda == null) {
						System.out.println("\nVenda não localizada.");
					}
					System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-10s\n",
							"ID", "CLIENE", "VEICULO", "VALOR", "DATA");
					if (venda != null) {
					venda.imprimir();
					}
					break;
				}
			}
		}
	}

	private int apresentarOpcoesMenuConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada.");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_VENDA + " - Consultar todos os clientes");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_VENDA + " - Consultar um cliente específico");
		System.out.println(OPCAO_MENU_CONSULTAR_VENDA_VOLTAR + " - Voltar ao menu cliente");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void excluirVenda() {
	
		VendaVO vendaVO = new VendaVO();
		System.out.print("\nDigite o código do client: ");
		vendaVO.setIdVenda(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.excluirVendaController(vendaVO);
		System.out.println(resultado);
	}
}

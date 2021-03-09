package view;

import java.util.Scanner;

public class Menu {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CLIENTE = 1;
	private static final int OPCAO_MENU_VEICULO = 2;
	private static final int OPCAO_MENU_VENDA = 3;
	private static final int OPCAO_MENU_RELATORIO = 4;
	private static final int OPCAO_MENU_SAIR = 5;

	public void apresentarMenu() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CLIENTE: {
					MenuCliente menuCliente = new MenuCliente();
					menuCliente.apresentarMenucliente();
					break;
				}
				case OPCAO_MENU_VEICULO: {
					MenuVeiculo menuVeiculo = new MenuVeiculo();
					menuVeiculo.apresentarMenuVeiculo();
					break;
				}
				case OPCAO_MENU_VENDA: {
					MenuVenda menuVenda = new MenuVenda();
					menuVenda.apresentarMenuVenda();
					break;
				}
				case OPCAO_MENU_RELATORIO: {
					MenuRelatorio menuRelatorio = new MenuRelatorio();
					menuRelatorio.apresentarMenuRelatorio();
					break;
				}
				default: {
					System.out.println("\nOpção inválida!");
				}
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}

	private int apresentarOpcoesMenu() {
		System.out.println("Revenda Ferro Velho");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CLIENTE + " - Menu Cliente");
		System.out.println(OPCAO_MENU_VEICULO + " - Menu Veículo");
		System.out.println(OPCAO_MENU_VENDA + " - Menu Venda");
		System.out.println(OPCAO_MENU_RELATORIO + " - Menu Relatorio");
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}

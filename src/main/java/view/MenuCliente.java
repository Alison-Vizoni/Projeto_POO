package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraCliente;
import model.vo.ClienteVO;

public class MenuCliente {
	
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_CADASTRAR_CLIENTE = 1;
	private static final int OPCAO_ALTERAR_CLIENTE = 2;
	private static final int OPCAO_RELATORIO_CLIENTE = 3;
	private static final int OPCAO_EXCLUIR_CLIENTE = 4;
	private static final int OPCAO_VOLTAR_MENU = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_CLIENTES = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_CLIENTES = 2;
	private static final int OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR = 3;

	public void apresentarMenucliente() {
		int opcao = this.manterCliente();
		
		while(opcao != OPCAO_VOLTAR_MENU) {
			switch (opcao) {
				case OPCAO_CADASTRAR_CLIENTE: {
					this.cadastrarCliente();
					break;
				}
				case OPCAO_ALTERAR_CLIENTE: {
					this.alterarCliente();
					break;
				}
				case OPCAO_RELATORIO_CLIENTE: {
					this.colsultarCliente();
					break;
				}
				case OPCAO_EXCLUIR_CLIENTE: {
					this.excluirCliente();
					break;
				}
				default: {
					System.out.println("\nOpção inválida!");
				}
			}
			opcao = this.manterCliente();
		}
	}

	private int manterCliente() {
		System.out.println("\nMenu Cliente:\n");
		System.out.println(OPCAO_CADASTRAR_CLIENTE + " - Inserir cliente");
		System.out.println(OPCAO_ALTERAR_CLIENTE + " - Alterar cliente");
		System.out.println(OPCAO_RELATORIO_CLIENTE + " - Relatório de cliente");
		System.out.println(OPCAO_EXCLUIR_CLIENTE + " - Excluir cliente");
		System.out.println(OPCAO_VOLTAR_MENU + " - Voltar ao menu principal");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarCliente() {
		
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("\nDigite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("Digite o cpf: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("Digite o telefone: ");
		clienteVO.setTelefone(teclado.nextLine());
		System.out.println("Digite a data de nascimento: ");
		clienteVO.setDtNascimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.cadastrarClienteController(clienteVO);
		System.out.println(resultado);
	}

	private void alterarCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("\nDigite o código do cliente: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("Digite o cpf: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("Digite o telefone: ");
		clienteVO.setTelefone(teclado.nextLine());
		System.out.println("Digite a data de nascimento: ");
		clienteVO.setDtNascimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.alterarClienteController(clienteVO);
		System.out.println(resultado);
	}

	private void colsultarCliente() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		while(opcao != OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_CLIENTES: {
					opcao = OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR;
					ArrayList<ClienteVO> listaCLientesVO = controladoraCliente.consultarTodosClientesController();
					if (listaCLientesVO.isEmpty()) {
						System.out.println("\nLista de clientes não localizada");
					}
					System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-10s",
							"ID", "NOME", "CPF", "TELEFONE", "DTNASCIMENTO");
					for(int i=0; i < listaCLientesVO.size(); i++) {
						listaCLientesVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_CLIENTES: {
					opcao = OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR;
					ClienteVO clienteVO = new ClienteVO();
					System.out.print("\nDigite o código do cliente: ");
					clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
					ClienteVO cliente = controladoraCliente.consultarClienteController(clienteVO);
					if (cliente == null) {
						System.out.println("\nCliente não localizado.");
					}
					System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-10s",
							"ID", "NOME", "CPF", "TELEFONE", "DTNASCIMENTO");
					if (cliente != null) {
						cliente.imprimir();
					}
					break;
				}
			}
		}
	}

	private int apresentarOpcoesMenuConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada.");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_CLIENTES + " - Consultar todos os clientes");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_CLIENTES + " - Consultar um cliente específico");
		System.out.println(OPCAO_MENU_CONSULTAR_CLIENTES_VOLTAR + " - Voltar ao menu cliente");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void excluirCliente() {
		
		ClienteVO clienteVO = new ClienteVO();
		System.out.print("\nDigite o código do cliente: ");
		clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.excluirClienteController(clienteVO);
		System.out.println(resultado);
		
	}
}

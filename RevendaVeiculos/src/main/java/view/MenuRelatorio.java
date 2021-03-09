package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraRelatorio;
import model.dto.FaturamentosDTO;
import model.dto.VendasDTO;

public class MenuRelatorio {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_TODAS_VENDAS_REALIZADAS = 1;
	private static final int OPCAO_FATURAMENTO_MES = 2;
	private static final int OPCAO_VOLTAR_MENU = 3;

	public void apresentarMenuRelatorio() {
		int opcao = this.apresentarOpcoes();
		
		while (opcao != OPCAO_VOLTAR_MENU) {
			switch(opcao) {
				case OPCAO_TODAS_VENDAS_REALIZADAS: {
					opcao = OPCAO_VOLTAR_MENU;
					this.consultarTodasVendasRealizadas();
					break;
				}
				case OPCAO_FATURAMENTO_MES: {
					opcao = OPCAO_VOLTAR_MENU;
					this.consultarFaturamentoMes();
					break;
				}
				default: {
					System.out.println("\nOpcão inválida.");
				}
			}
		}
	}

	private int apresentarOpcoes() {
		System.out.println("\nMenu de reatorios.");
		System.out.println(OPCAO_TODAS_VENDAS_REALIZADAS + " Relatório de todas as vendas realizadas");
		System.out.println(OPCAO_FATURAMENTO_MES + " Relatorio do faturamento mensal");
		System.out.println(OPCAO_VOLTAR_MENU + " Voltar ao menu");
		System.out.println("\nDigite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

	private void consultarTodasVendasRealizadas() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<VendasDTO> listaVendasDTO = controladoraRelatorio.ConsultarTodasVendasRealizadasController();
		if (listaVendasDTO.isEmpty()) {
			System.out.println("\nLista de vendas não localizadas.");
		}
		System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
		System.out.printf("\n%10s   %-10s   %-10s   %-10s   %-10s   %-10s   %-10s\n",
				"NOME", "CPF", "TELEFONE", "MODELO", "PLACA", "DATAVENDA", "VALORVENDA");
		for (int i=0; i < listaVendasDTO.size();i++) {
			listaVendasDTO.get(i).imprimir();
		}
	}

	private void consultarFaturamentoMes() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<FaturamentosDTO> listaFaturamentoMesDTO = controladoraRelatorio.consultarFaturamentoMesController();
		if (listaFaturamentoMesDTO.isEmpty()) {
			System.out.println("\nLista de faturamento não localizada.");
		}
		System.out.print("\n--------- RESULTADO DA CONSULTA ----------");
		System.out.printf("\n%10s   %-10s   %-10s\n",
				"MES", "ANO", "TOTALVENDAS");
		for (int i=0; i < listaFaturamentoMesDTO.size();i++) {
			listaFaturamentoMesDTO.get(i).imprimir();
		}
	}
}
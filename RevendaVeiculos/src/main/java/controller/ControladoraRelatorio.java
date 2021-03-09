package controller;

import java.util.ArrayList;

import model.bo.RelatorioBO;
import model.dto.FaturamentosDTO;
import model.dto.VendasDTO;

public class ControladoraRelatorio {

	public ArrayList<VendasDTO> ConsultarTodasVendasRealizadasController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.consultarTodasVendasRealizadasBO();
	}

	public ArrayList<FaturamentosDTO> consultarFaturamentoMesController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.consultarFaturamentoMesBO();
	}

}

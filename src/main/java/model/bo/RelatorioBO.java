package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioDAO;
import model.dto.FaturamentosDTO;
import model.dto.VendasDTO;

public class RelatorioBO {

	public ArrayList<VendasDTO> consultarTodasVendasRealizadasBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		return relatorioDAO.consultarTodasVendasRealizadasDAO();
	}

	public ArrayList<FaturamentosDTO> consultarFaturamentoMesBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		return relatorioDAO.consultarFaturamentoMesDAO();
	}

}

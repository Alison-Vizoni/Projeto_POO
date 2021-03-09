package controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.VendaBO;
import model.vo.VendaVO;

public class ControladoraVenda {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public String CadastrarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO(); 
		return vendaBO.cadastrarVendaBO(vendaVO);
	}

	public String excluirVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO(); 
		return vendaBO.excluirVendaBO(vendaVO);
	}

	public String alterarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO(); 
		return vendaBO.alterarVendaBO(vendaVO);
	}

	public ArrayList<VendaVO> consultarTodasVendasController() {
		VendaBO vendaBO = new VendaBO(); 
		return vendaBO.consultarTodasVendasBO();
	}

	public VendaVO consultarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO(); 
		return vendaBO.consultarVendaBO(vendaVO);
	}

}

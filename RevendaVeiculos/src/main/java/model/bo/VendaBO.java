package model.bo;

import java.util.ArrayList;

import model.dao.VendaDAO;
import model.vo.VendaVO;

public class VendaBO {
	
	// Regras de negocio

	public String cadastrarVendaBO(VendaVO vendaVO) {
		String retorno = "";
		VendaDAO vendaDAO = new VendaDAO();
		int resultado = vendaDAO.cadastrarVendaDAO(vendaVO);
		if (resultado == 1) {
			retorno = "\nVenda cadastrada com sucesso.";
		} else {
			retorno = "\nNão foi possivel cadastrar a venda.";
		}
		return retorno;
	}

	public String excluirVendaBO(VendaVO vendaVO) {
		String retorno = "";
		VendaDAO vendaDAO = new VendaDAO();
		if(vendaDAO.verificarRegistroIdVenda(vendaVO.getIdVenda())) {
			int resultado = vendaDAO.excluirVendaDAO(vendaVO);
			if (resultado == 1) {
				retorno = "\nVenda excluida com sucesso.";
			} else {
				retorno = "\nNão foi possivel excluir a venda.";
			}
		} else {
			retorno = "\nVenda ainda não foi cadastrada no banco";
		}
		return retorno;
	}

	public String alterarVendaBO(VendaVO vendaVO) {
		String retorno = "";
		VendaDAO vendaDAO = new VendaDAO();
		if(vendaDAO.verificarRegistroIdVenda(vendaVO.getIdVenda())) {
			int resultado = vendaDAO.alterarVendaDAO(vendaVO);
			if (resultado == 1) {
				retorno = "\nVenda atualizada com sucesso.";
			} else {
				retorno = "\nNão foi possivel atualizar a venda.";
			}
		} else {
			retorno = "\nVenda ainda não foi cadastrada no banco";
		}
		return retorno;
	}

	public ArrayList<VendaVO> consultarTodasVendasBO() {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.consultarTodasVendasDAO();
	}

	public VendaVO consultarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.consultarVendasDAO();
	}

}

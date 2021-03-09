package model.bo;

import java.util.ArrayList;
import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {
	
	// Regras de negocio

	public String cadastrarClienteBO(ClienteVO clienteVO) {
		String retorno = "";
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.verificarRegistroCpf(clienteVO.getCpf())) {
			retorno = "\ncliente Já cadastrado no banco.";
		} else {
			int resultado = clienteDAO.cadastrarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente cadastrado com sucesso.";
			} else {
				retorno = "\nNão foi possivel cadastrar o cliente.";
			}
		}
		return retorno;
	}

	public String alterarClienteBO(ClienteVO clienteVO) {
		String retorno = "";
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.verificarRegistroIdCliente(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.alterarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente atualizado com sucesso.";
			} else {
				retorno = "\nNão foi possivel atualizar o cliente.";
			}
		} else {
			retorno = "\nCliente ainda não foi cadastrado no banco";
		}
		return retorno;
	}

	public String excluirClienteBO(ClienteVO clienteVO) {
		String retorno = "";
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.verificarRegistroIdCliente(clienteVO.getIdCliente())) {
			int resultado = clienteDAO.excluirClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\nCliente excluido com sucesso.";
			} else {
				retorno = "\nNão foi possivel excluir o cliente.";
			}
		} else {
			retorno = "\nCliente ainda não foi cadastrado no banco";
		}
		return retorno;
	}

	public ArrayList<ClienteVO> consultarTodosClientesBO() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarTodosClientesDAO();
	}

	public ClienteVO consultarClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarClientesDAO(clienteVO);
	}

}

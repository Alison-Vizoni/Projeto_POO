package controller;

import java.util.ArrayList;
import model.bo.ClienteBO;
import model.vo.ClienteVO;

public class ControladoraCliente {

	public String cadastrarClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.cadastrarClienteBO(clienteVO);
	}

	public String alterarClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.alterarClienteBO(clienteVO);
	}

	public String excluirClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.excluirClienteBO(clienteVO);
	}
	
	public ArrayList<ClienteVO> consultarTodosClientesController() {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarTodosClientesBO();
	}

	public ClienteVO consultarClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarClienteBO(clienteVO);
	}

}

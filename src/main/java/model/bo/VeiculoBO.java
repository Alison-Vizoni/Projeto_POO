package model.bo;

import java.util.ArrayList;

import model.dao.VeiculoDAO;
import model.vo.VeiculoVO;

public class VeiculoBO {
	
	// Regras de negocio

	public String cadastrarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if (veiculoDAO.verificarRegistroPorPlaca(veiculoVO.getPlaca())) {
			retorno = "\nVeículo já cadastrado no banco.";
		} else {
			int resultado = veiculoDAO.cadastrarVeiculoDAO(veiculoVO);
			if(resultado == 1) {
				retorno = "\nVeículo cadastrado com sucesso.";
			} else {
				retorno = "\nNão foi possivel cadastrar o veiculo.";
			}
			
		}
		return retorno;
	}

	public String excluirVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if (veiculoDAO.verificarRegistroPorIdVeiculo(veiculoVO.getIdveiculo())) {
			int resultado = veiculoDAO.excluirVeiculoDAO(veiculoVO);
			if (resultado == 1) {
				retorno = "\nVeiculo excluido com sucesso.";
			} else {
				retorno = "\nNão foi possivel excluir o veículo.";
			}
		} else {
			retorno = "\nVeiculo ainda não foi cadastrado no banco";
		}
		return retorno;
	}

	public String atualizarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if (veiculoDAO.verificarRegistroPorIdVeiculo(veiculoVO.getIdveiculo())) {
			int resultado = veiculoDAO.atualizarVeiculoDAO(veiculoVO);
			if (resultado == 1) {
				retorno = "\nVeiculo atualizado com sucesso.";
			} else {
				retorno = "\nNão foi possivel atualizar o veículo.";
			}
		} else {
			retorno = "\nVeiculo ainda não foi cadastrado no banco";
		}
		return retorno;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosBO() {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		 return veiculoDAO.consultarTodosVeiculosDAO();
	}

	public VeiculoVO consultarVeiculoBO(VeiculoVO veiculoVO) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		 return veiculoDAO.consultarVeiculosDAO(veiculoVO);
	}

}

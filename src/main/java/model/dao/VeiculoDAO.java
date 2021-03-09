package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class VeiculoDAO {

	public boolean verificarRegistroPorPlaca(String placa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idveiculo FROM veiculo WHERE PLACA = '" + placa + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica veiculo por placa");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO veiculo (modelo, tipo, fabricante, ano, cor, placa) VALUES ('"
					+ veiculoVO.getModelo() + "', '"
					+ veiculoVO.getTipo() + "', '"
					+ veiculoVO.getFabricante() + "', "
					+ veiculoVO.getAno() + ", '"
					+ veiculoVO.getCor() + "', '"
					+ veiculoVO.getPlaca() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de veiculo");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean verificarRegistroPorIdVeiculo(int idveiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idveiculo FROM veiculo WHERE idveiculo = " + idveiculo;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ai executar a query que verifica veiculo por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return true;
	}

	public int excluirVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM veiculo WHERE idveiculo = " + veiculoVO.getIdveiculo();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a execução do veiculo.");
		} 	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE veiculo SET modelo = '" + veiculoVO.getModelo() + "', "
				+ "tipo = '" + veiculoVO.getTipo() + "', "
				+ "fabricante = '" + veiculoVO.getFabricante() + "', "
				+ "ano = " + veiculoVO.getAno() + ", "
				+ "cor = '" + veiculoVO.getCor() + "', "
				+ "placa = '" + veiculoVO.getPlaca() + "' "
				+ "WHERE idveiculo = " + veiculoVO.getIdveiculo();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização do veículo.");
		} 	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		ArrayList<VeiculoVO> lista = new ArrayList<VeiculoVO>();
		String query = "SELECT idveiculo, modelo, tipo, fabricante, ano, cor, placa FROM veiculo";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				VeiculoVO veiculo = new VeiculoVO();
				veiculo.setIdveiculo(Integer.parseInt(resultado.getString(1)));
				veiculo.setModelo(resultado.getString(2));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString(3)));
				veiculo.setFabricante(resultado.getString(4));
				veiculo.setAno(Integer.parseInt(resultado.getString(5)));
				veiculo.setCor(resultado.getString(6));
				veiculo.setPlaca(resultado.getString(7));
				lista.add(veiculo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consultar todos os veiculos");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

	public VeiculoVO consultarVeiculosDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		VeiculoVO veiculo = null;
		String query = "SELECT idveiculo, modelo, tipo, fabricante, ano, cor, placa "
					+ "FROM veiculo WHERE idveiculo = " + veiculoVO.getIdveiculo();
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				veiculo = new VeiculoVO();
				veiculo.setIdveiculo(Integer.parseInt(resultado.getString(1)));
				veiculo.setModelo(resultado.getString(2));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString(3)));
				veiculo.setFabricante(resultado.getString(4));
				veiculo.setAno(Integer.parseInt(resultado.getString(5)));
				veiculo.setCor(resultado.getString(6));
				veiculo.setPlaca(resultado.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de um veiculo");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return veiculo;
	}
}

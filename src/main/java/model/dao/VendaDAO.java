package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.VendaVO;

public class VendaDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public int cadastrarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO venda (idcliente, idveiculo, valorvenda, datavenda) VALUES ("
				+ vendaVO.getIdCliente() + ", "
				+ vendaVO.getIdVeiculo() + ", "
				+ vendaVO.getValorVenda() + ", '"
				+ vendaVO.getDataVenda() + "')";
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de venda.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean verificarRegistroIdVenda(int idVenda) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idvenda FROM venda WHERE idvenda = " + idVenda;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ai executar a query que verifica venda por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return true;
	}

	public int excluirVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM venda WHERE idvenda = " + vendaVO.getIdVenda();

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

	public int alterarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE venda SET idcliente = " + vendaVO.getIdCliente() + ", "
					+ "idveiculo = " + vendaVO.getIdVeiculo() + ", " 
					+ "valorvenda = " + vendaVO.getValorVenda() + ", " 
					+ "datavenda = '" + vendaVO.getDataVenda() + "' "
					+ "WHERE idvenda = " + vendaVO.getIdVenda();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a atualização da venda.");
		} 	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<VendaVO> consultarTodasVendasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		ArrayList<VendaVO> lista = new ArrayList<VendaVO>();
		String query = "SELECT idvenda, idcliente, idveiculo, valorvenda, datavenda FROM venda";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				VendaVO venda = new VendaVO();
				venda.setIdVenda(resultado.getInt(1));
				venda.setIdCliente(resultado.getInt(2));
				venda.setIdVeiculo(resultado.getInt(3));
				venda.setValorVenda(resultado.getDouble(4));
				venda.setDataVenda(LocalDate.parse(resultado.getString(5), dataFormatter));
				lista.add(venda);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consultar todas as vendas");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	public VendaVO consultarVendasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		VendaVO venda = null;
		String query = "SELECT idvenda, idcliente, idveiculo, valorvenda, datavenda FROM venda";
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				venda = new VendaVO();
				venda.setIdVenda(resultado.getShort(1));
				venda.setIdCliente(resultado.getShort(2));
				venda.setIdVeiculo(resultado.getShort(3));
				venda.setValorVenda(resultado.getShort(4));
				venda.setDataVenda(LocalDate.parse(resultado.getString(5), dataFormatter));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de uma venda");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return venda;
	}

}

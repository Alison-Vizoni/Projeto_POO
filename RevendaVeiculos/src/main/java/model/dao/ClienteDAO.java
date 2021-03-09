package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.vo.ClienteVO;

public class ClienteDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public boolean verificarRegistroCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT cpf FROM cliente WHERE cpf = '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ai executar a query que verifica cliente por cpf");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO cliente (nome, cpf, telefone, dtnascimento) VALUES ('"
				+ clienteVO.getNome() + "', '"
				+ clienteVO.getCpf() + "', '"
				+ clienteVO.getTelefone() + "', '"
				+ clienteVO.getDtNascimento() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de cliente");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean verificarRegistroIdCliente(int idCliente) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idcliente FROM cliente WHERE idcliente = '" + idCliente + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ai executar a query que verifica cliente por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return true;
	}

	public int alterarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE cliente SET  nome = '" + clienteVO.getNome() + "', "
				+ "cpf = '" + clienteVO.getCpf() + "', "
				+ "telefone = '"+clienteVO.getTelefone() + "', "
				+ "dtnascimento = '" + clienteVO.getDtNascimento() + "' "
				+ "WHERE idcliente = " + clienteVO.getIdCliente();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização do cliente.");
		} 	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM cliente WHERE idcliente = " + clienteVO.getIdCliente();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a execução do cliente.");
		} 	finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ClienteVO> consultarTodosClientesDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
		String query = "SELECT idcliente, nome, cpf, telefone, dtnascimento FROM cliente";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
				cliente.setNome(resultado.getString(2));
				cliente.setCpf(resultado.getString(3));
				cliente.setTelefone(resultado.getString(4));
				cliente.setDtNascimento(LocalDate.parse(resultado.getString(5), dataFormatter));
				lista.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consultar todos os clientes");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return lista;
	}

	public ClienteVO consultarClientesDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		ClienteVO cliente = null;
		String query = "SELECT idcliente, nome, cpf, telefone, dtnascimento "
				+ "FROM cliente WHERE idcliente = " + clienteVO.getIdCliente();
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				cliente = new ClienteVO();
				cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
				cliente.setNome(resultado.getString(2));
				cliente.setCpf(resultado.getString(3));
				cliente.setTelefone(resultado.getString(4));
				cliente.setDtNascimento(LocalDate.parse(resultado.getString(5), dataFormatter));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de um cliente.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cliente;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dto.FaturamentosDTO;
import model.dto.VendasDTO;

public class RelatorioDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ArrayList<VendasDTO> consultarTodasVendasRealizadasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		ArrayList<VendasDTO> lista = new ArrayList<VendasDTO>();
		
		String query = "SELECT" + 
				" CLIENTE.nome" + 
				", CLIENTE.cpf" + 
				", CLIENTE.telefone" + 
				", VEICULO.modelo" + 
				", VEICULO.placa" + 
				", VENDA.dataVenda" + 
				", VENDA.valorVenda" + 
				" FROM" + 
				" CLIENTE" + 
				" INNER JOIN VENDA ON" + 
				" CLIENTE.IDCLIENTE = VENDA.IDCLIENTE" + 
				" INNER JOIN VEICULO ON" + 
				" VEICULO.IDVEICULO = VENDA.IDVEICULO";
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				VendasDTO vendas = new VendasDTO();
				vendas.setNome(resultado.getString(1));
				vendas.setCpf(resultado.getString(2));
				vendas.setTelefone(resultado.getString(3));
				vendas.setModelo(resultado.getString(4));
				vendas.setPlaca(resultado.getString(5));
				vendas.setDataVenda(LocalDate.parse(resultado.getString(6), dataFormatter));
				vendas.setValorVenda(Double.parseDouble(resultado.getString(7)));
				lista.add(vendas);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar query de consultar vendas realizadas");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	public ArrayList<FaturamentosDTO> consultarFaturamentoMesDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);	
		ResultSet resultado = null;
		ArrayList<FaturamentosDTO> lista = new ArrayList<FaturamentosDTO>();
		
		String query = "SELECT" + 
				" MONTH(DATAVENDA)" + 
				" , YEAR(DATAVENDA)" + 
				" , SUM(VALORVENDA)" + 
				" FROM" + 
				" VENDA" + 
				" GROUP BY" + 
				" MONTH(DATAVENDA)" + 
				" , YEAR(DATAVENDA)" + 
				" ORDER BY" + 
				" YEAR(DATAVENDA) DESC;";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				FaturamentosDTO faturamentos = new FaturamentosDTO();
				faturamentos.setMes(Integer.parseInt(resultado.getString(1)));
				faturamentos.setAno(Integer.parseInt(resultado.getString(2)));
				faturamentos.setTotalVendas(Double.parseDouble(resultado.getString(3)));
				lista.add(faturamentos);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar query de faturamnto");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

}

package br.com.puglia.galassini.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.puglia.galassini.mapper.PedidosMapper;
import br.com.puglia.galassini.models.Pedidos;

public class PedidosDao {

	private JdbcTemplate jdbcTemplate;

	public PedidosDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirPedido(Pedidos pedidos) {
		try{
			String sql = "INSERT INTO TB_PEDIDOS (IDCLIENTE, DESCRICAO, DATA, RESPONSAVEL, PRECO)"
				+ " VALUES (?, ?, ?, ?, ?)";
			this.jdbcTemplate.update(sql, 
					pedidos.getIdCliente(),
					pedidos.getDescricao(),
					new java.sql.Date(pedidos.getData().getTime()),
					pedidos.getResponsavel(),
					pedidos.getPreco());
		} catch (Exception e) {
			throw e;
		}
	}
public void alterarPedido(Pedidos pedidos) throws Exception {
	 try {
		String sql ="UPDATE TB_PEDIDOS SET, IDCLIENTE=?, DESCRICAO=?, DATA=?, RESPONSAVEL=?, PRECO=?"
				+ "WHERE ID=?";
		
		this.jdbcTemplate.update(sql, 
				pedidos.getIdCliente(),
				pedidos.getDescricao(),
				new java.sql.Date(pedidos.getData().getTime()),
				pedidos.getResponsavel(),
				pedidos.getPreco());
	} catch (Exception e) {
		throw e;
	
	}
}
	public List<Pedidos> listarPedidos() {
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		try {
			pedidos = this.jdbcTemplate.query("SELECT * FROM TB_PEDIDOS", new PedidosMapper());
			
		} catch (Exception e) {
			throw e;
		}
		return pedidos;
	}
	public Pedidos buscarPedidos (int id) {
		Pedidos pedidos = null;
		try {
			pedidos = this.jdbcTemplate.queryForObject(
					"SELECT * FROM TB_PEDIDOS WHERE ID = ?", 
					new PedidosMapper(),
					new Object[] { id });
		} catch (Exception e) {
			throw e;
		}
		return pedidos;
	}
	public int excluirPedidos(int id) {
		int compra = 0;
		try {
         compra = this.jdbcTemplate.update("DELETE FROM TB_PEDIDOS WHERE ID = ?", id);
		} catch (Exception e) {
			throw e;
		}
		return compra;
	
}
	

}
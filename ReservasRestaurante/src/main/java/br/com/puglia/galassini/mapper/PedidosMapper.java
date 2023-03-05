package br.com.puglia.galassini.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.puglia.galassini.models.Pedidos;

public class PedidosMapper implements RowMapper<Pedidos>{

	@Override
	public Pedidos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pedidos pedido = new Pedidos();
		pedido.setIdCliente(rs.getInt("ID"));
		pedido.setDescricao(rs.getString("DESCRICAO"));
		pedido.setData(rs.getDate("DATA"));
		pedido.setResponsavel(rs.getString("RESPONSAVEL"));
		pedido.setPreco(rs.getDouble("PRECO"));
		
		return pedido;
	}
	
	

}

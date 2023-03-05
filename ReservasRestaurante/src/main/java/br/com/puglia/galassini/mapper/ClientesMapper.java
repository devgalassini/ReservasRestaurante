package br.com.puglia.galassini.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.puglia.galassini.models.Clientes;

public class ClientesMapper implements RowMapper<Clientes> {

	@Override
	public Clientes mapRow(ResultSet rs, int rowNum) throws SQLException {
		Clientes cliente = new Clientes();
		cliente.setId(rs.getInt("ID"));
		cliente.setNome(rs.getString("NOME"));
		cliente.setEmail(rs.getString("EMAIL"));
		
		return cliente;
	}
	
	

}

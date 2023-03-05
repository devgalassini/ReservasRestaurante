package br.com.puglia.galassini.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.puglia.galassini.mapper.ClientesMapper;
import br.com.puglia.galassini.models.Clientes;

public class ClientesDao {

	private JdbcTemplate jdbcTemplate;

	public ClientesDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirClinte(Clientes clientes) {
		try {
			String sql = "INSERT INTO TB_CLINETES (ID, NOME, EMAIL)" 
		+ "VALUES (?, ?, ?)";
			this.jdbcTemplate.update(sql, 
					clientes.getId(), 
					clientes.getNome(), 
					clientes.getEmail());

		} catch (Exception e) {
			throw e;
		}
	}
public void alterarCliente(Clientes clientes) throws Exception {
	 try {
		String sql ="UPDATE TB_CLIENTES SET, NOME=?, EMAIL=?"
				+ "WHERE ID=?";
		
		this.jdbcTemplate.update(sql,
				clientes.getId(),
				clientes.getNome(),
				clientes.getEmail());
		 
	} catch (Exception e) {
		throw e;
	}
}
	public List<Clientes> listarClientes() {
		List<Clientes> clientes = new ArrayList<Clientes>();
		try {
			clientes = this.jdbcTemplate.query("SELECT * FROM TB_CLIENTES", new ClientesMapper());
			
		} catch (Exception e) {
			throw e;
		}
		return clientes;
	}
	public Clientes buscarClientes (int id) {
		Clientes clientes = null;
		try {
			clientes = this.jdbcTemplate.queryForObject(
					"SELECT * FROM TB_EVENTOS WHERE ID = ?", 
					new ClientesMapper(),
					new Object[] { id });
		} catch (Exception e) {
			throw e;
		}
		return clientes;
	}
	public int excluirClientes(int id) {
		int cadastro = 0;
		try {
			cadastro = this.jdbcTemplate.update("DELETE FROM TB_CLIENTES WHERE ID = ?", id);
		} catch (Exception e) {
			throw e;
		}
		return cadastro;
	
}
	

}
package br.com.puglia.galassini.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.puglia.galassini.mapper.ReservaMesaMapper;
import br.com.puglia.galassini.models.MesaReserva;

public class ReservaMesaDao {
	private JdbcTemplate jdbcTemplate;

	public ReservaMesaDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirMesa(MesaReserva mesaReserva) {
		try{
			String sql = "INSERT INTO TB_MESA (ID, NUMERO)"
				+ " VALUES (?, ?)";
			this.jdbcTemplate.update(sql, 
					mesaReserva.getId(),
					mesaReserva.getNumero());
			
		} catch (Exception e) {
			throw e;
		}
	}
public void alterarMesa(MesaReserva mesaReserva) throws Exception {
	 try {
		String sql ="UPDATE TB_MESA SET, ID=?, NUMERO=?"
				+ "WHERE ID=?";
		
		this.jdbcTemplate.update(sql, 
				mesaReserva.getId(),
				mesaReserva.getNumero());
	} catch (Exception e) {
		throw e;
	
	}
}
	public List<MesaReserva> listarMesa() {
		List<MesaReserva> reservas = new ArrayList<MesaReserva>();
		try {
			reservas = this.jdbcTemplate.query("SELECT * FROM TB_MESA", new ReservaMesaMapper());
			
		} catch (Exception e) {
			throw e;
		}
		return reservas;
	}
	public MesaReserva buscarMesa (int id) {
		MesaReserva reserva = null;
		try {
			reserva = this.jdbcTemplate.queryForObject(
					"SELECT * FROM TB_MESA WHERE ID = ?", 
					new ReservaMesaMapper(),
					new Object[] { id });
		} catch (Exception e) {
			throw e;
		}
		return reserva;
	}
	public int excluirMesa(int id) {
		int mesa = 0;
		try {
         mesa = this.jdbcTemplate.update("DELETE FROM TB_MESA WHERE ID = ?", id);
		} catch (Exception e) {
			throw e;
		}
		return mesa;
	
}
	


}
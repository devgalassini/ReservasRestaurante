package br.com.puglia.galassini.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.puglia.galassini.models.MesaReserva;

public class ReservaMesaMapper implements RowMapper<MesaReserva> {

	@Override
	public MesaReserva mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MesaReserva mesaReserva = new MesaReserva();
		mesaReserva.setNumero(rs.getInt("ID"));
		mesaReserva.setId(rs.getInt("NUMERO"));
		
		return mesaReserva;
	}
	
	

}

package br.com.puglia.galassini.models;

public class MesaReserva {

	private int numero;
	private int id;
	
	public MesaReserva(int numero, int id) {
		this.numero = numero;
		this.id = id;
	}

	public MesaReserva() {
		// TODO Auto-generated constructor stub
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MesaReserva [numero=" + numero + ", id=" + id + "]";
	}
	

}
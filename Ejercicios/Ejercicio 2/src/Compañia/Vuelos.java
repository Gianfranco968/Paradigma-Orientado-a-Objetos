package Compañia;

public abstract class Vuelos {
	
	private int numeroVuelo;
	private String destino;
	private int capacidadMax;
	private int asientosOcupados;
	
	public int getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}
	public int getAsientosOcupados() {
		return asientosOcupados;
	}
	public void setAsientosOcupados(int asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}
	public abstract int getCantEscala();
	public abstract int getCategoria();
}

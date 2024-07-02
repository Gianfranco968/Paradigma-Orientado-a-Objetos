package Negocio;

public class Compras_con_tarjeta extends Compras{

	private int puntosConTarjeta = 20;
	private int numeroTarjeta;
	
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public double realizarDescuento() {
		double descuento = (super.importe * 2.0) / 100.0;
		return(descuento);
	}
	public int cargarPuntos() {
		return(puntosConTarjeta);
	}
}

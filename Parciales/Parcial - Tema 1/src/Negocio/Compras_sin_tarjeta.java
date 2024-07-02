package Negocio;

public class Compras_sin_tarjeta extends Compras{

	private int puntosSinTarjeta = 10;
	
	public double realizarDescuento() {
		double descuento = (super.importe * 2.0) / 100.0;
		return(descuento);
	}
	public int cargarPuntos() {
		return(puntosSinTarjeta);
	}
}

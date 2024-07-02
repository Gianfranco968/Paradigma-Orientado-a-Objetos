package Empresa;

public class Doble extends Habitaciones{

	private int precioBase = 50000;
	
	public double calcularPrecio() {
		return(super.importe = (precioBase + ((precioBase * 35) / 100)));
	}
}
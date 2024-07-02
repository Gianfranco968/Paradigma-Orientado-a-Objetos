package Empresa;

public class Matrimonial extends Habitaciones{

	private int precioBase = 50000;
	
	public double calcularPrecio() {
		return(super.importe = (precioBase + ((precioBase * 50) / 100)));
	}
}
package Negocio;

public class Autos_nacionales extends Autos{

	private double impuesto;
	private double costoFabricacion;
	
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	public double getCostoFabricacion() {
		return costoFabricacion;
	}
	public void setCostoFabricacion(double costoFabricacion) {
		this.costoFabricacion = costoFabricacion;
	}
	public double calcularPrecio() {
		return(super.precioVenta - (this.impuesto + this.costoFabricacion));
	}
}

package empresa;

public class Nacional extends Auto{
	
	private double costoFabricacion;
	
	public double getCostoFabricacion() {
		return costoFabricacion;
	}
	public void setCostoFabricacion(double costoFabricacion) {
		this.costoFabricacion = costoFabricacion;
	}
	public double calcularCosto() {
		return super.precioVenta - this.costoFabricacion;
	}

}

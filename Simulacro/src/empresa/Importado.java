package empresa;

public class Importado extends Auto {

	private double costo;
	private double impuesto;
	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	public double calcularCosto() {
		return super.precioVenta - (this.costo + this.impuesto);
	}
}


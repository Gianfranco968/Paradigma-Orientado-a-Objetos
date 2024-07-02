package Empresa;

public abstract class Habitaciones {

	private int tipoDeHabitacion;
	protected double importe;
	
	public int getTipoDeHabitacion() {
		return tipoDeHabitacion;
	}
	public void setTipoDeHabitacion(int tipoDeHabitacion) {
		this.tipoDeHabitacion = tipoDeHabitacion;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public abstract double calcularPrecio();
}
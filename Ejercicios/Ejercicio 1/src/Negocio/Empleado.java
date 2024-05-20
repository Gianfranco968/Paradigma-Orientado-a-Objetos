package Negocio;

public class Empleado extends Empresa {
	private int dni;
	private String nombre;
	private String domicilio;
	protected double sueldoNeto;
	protected double sueldoBruto;
	
	public int getDocumento() {
		return dni;
	}
	public void setDocumento(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public double getSueldoNeto() {
		return sueldoNeto;
	}
	public void setSueldoNeto(double sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}
	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
}

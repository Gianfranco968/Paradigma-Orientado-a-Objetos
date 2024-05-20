package Negocio;
import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Empleado> empleado;
	
	public Empresa() {
		empleado = new ArrayList<Empleado>();
	}
	
	public void agregarEmpleado(Empleado e) {
		empleado.add(e);
	}
	public void eliminarEmpleado(int dni) {
		for(int i = 0; i < empleado.size(); i++) {
			if(empleado.get(i).getDocumento() == dni) {
				empleado.remove(i);
				return;
			}
		}
	}
	public double determinarSueldoNeto(int dni) {
		double sueldo = 0;
		for(int i = 0; i < empleado.size(); i++) {
			if(empleado.get(i).getDocumento() == dni) {
				sueldo = empleado.get(i).getSueldoNeto();
				break;
			}
		} return sueldo;
	}
	public String empleadoMayorSueldo() {
		String trabajador = "";
		for(int i = 1; i < empleado.size(); i++) {
			if(empleado.get(i).getSueldoBruto() > empleado.get(0).getSueldoBruto()) {
				trabajador = empleado.get(i).getNombre();
			}
		} return trabajador;
	}
}

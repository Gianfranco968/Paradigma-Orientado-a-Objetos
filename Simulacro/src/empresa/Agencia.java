package empresa;

import java.util.ArrayList;

public class Agencia {

	private ArrayList<Auto> autos;
	
	public Agencia() {
		autos = new ArrayList<Auto>();
	}
	public void agregarAuto(Auto a) {
		autos.add(a);
	}
	public void eliminarAuto(int id) {
		for(int i = 0; i < autos.size(); i++) {
			if(autos.get(i).getId() == id) {
				autos.remove(i);
				return;
			}
		}
	}
	public double calcularGanancia(int id) {
		for(int i = 0; i < autos.size(); i++) {
			if(autos.get(i).getId() == id) {
				return autos.get(i).calcularCosto();
			}
		} 
		return 0;
	}
	public double calcularGananciaTotal() {
		double total = 0;
		for(int i = 0; i < autos.size(); i++) {
			total = total + autos.get(i).calcularCosto();
		} return total;
	}
}

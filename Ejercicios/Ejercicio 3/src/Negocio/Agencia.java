package Negocio;
import java.util.ArrayList;
public class Agencia {

	private ArrayList<Autos> autos;
	
	public Agencia() {
		autos = new ArrayList<Autos>();
	}
	
	public void agregarAuto(Autos a) {
		autos.add(a);
	}
	
	public boolean existeAuto(int codigo) {
		if(!catalogoVacio()) {
			for(int i = 0; i < autos.size(); i++) {
				if(autos.get(i).getCodigo() == codigo) {
					System.out.println("\nDicho auto se encuentra en el catalogo!\n");
					return true;
				}
			} 
			return false;
		} else {
			return false;
		}
	}
	
	public boolean catalogoVacio() {
		if(autos.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public double calcularGanacia(int codigo) {
		double ganancia = 0;
		for(int i = 0; i < autos.size(); i++) {
			if(autos.get(i).getCodigo() == codigo) {
				ganancia = autos.get(i).calcularPrecio(); 
				return ganancia;
			}
		} return 0;
	}
	
	public void eliminarAuto(int codigo) {
		for(int i = 0; i < autos.size(); i++) {
			if(autos.get(i).getCodigo() == codigo) {
				autos.remove(i);
				System.out.println("\nAuto con ID " + codigo + " eliminado exitosamente!\n");
				return;
			}
		}
		System.out.println("\nEl auto con ID " + codigo + " no existe!\n");
		return;
	}
	
	public void calcularGananciaTotal() {
		double gananciaTotal = 0;
		for(int i = 0; i < autos.size(); i++) {
			gananciaTotal += autos.get(i).calcularPrecio();
		}
		System.out.println("La ganancia total obtenida es de: $ " + gananciaTotal);
	}
}

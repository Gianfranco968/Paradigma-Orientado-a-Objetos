package Compañia;
import java.util.ArrayList;

public class Aerolinea {
	
	private ArrayList<Vuelos> vuelos;
	
	public Aerolinea() {
		vuelos = new ArrayList<Vuelos>(); 
	}
	
	public void agregarVuelos(Vuelos a) {
		vuelos.add(a);
	}
	public int informarAsientosDisp(int numeroVuelo) {
		int disponibles = 0;
		for(int i = 0; i < vuelos.size(); i++) {
			if(vuelos.get(i).getNumeroVuelo() == numeroVuelo) {
				disponibles = vuelos.get(i).getCapacidadMax() - vuelos.get(i).getAsientosOcupados();
			}
		} return disponibles;
	}
	public int informarCantEscalas(int numeroVuelo) {
		int escalas = 0;
		for(int i = 0; i < vuelos.size(); i++) {
			if(vuelos.get(i).getNumeroVuelo() == numeroVuelo) {
				escalas = vuelos.get(i).getCantEscala();
			}
		} return escalas;
	}
}

package Negocio;
import java.util.ArrayList;

public class Cooperativa {

	private ArrayList<Compras> compra;
	private ArrayList<Socios> socio;
	
	public Cooperativa() {
		compra = new ArrayList<Compras>();
		socio = new ArrayList<Socios>();
	}
	
	public void agregarSocio(Socios s) {
		socio.add(s);
	}
	
	public void realizarCompra(Compras c) {
		compra.add(c);
	}
	
	public void informarCompras(int dni) {
		if(!catalogoVacio()) {
			if(existeSocio(dni)) {
				for(int i = 0; i < compra.size(); i++) {
					if(compra.get(i).getUsuario() == dni) {
						System.out.println("Compra N°: " + compra.get(i).getCodigo());
						System.out.println("Fecha: " + compra.get(i).getFecha());
						System.out.println("Descripcion: " + compra.get(i).getDescripcion());
						System.out.println("Importe: " + compra.get(i).getImporte() + "\n");
					}
				}
			} else {
				System.out.println("\nEl socio con DNI " + dni + " no existe!\n");
			}
			return;
		} else {
			System.out.println("\nERROR --> Debe registral al menos un socio o realizar una compra!\n");
		}
	}
	
	public boolean catalogoVacio() {
		if(compra.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean existeSocio(int dni) {
		for(int i = 0; i < socio.size(); i++) {
			if(socio.get(i).getDni() == dni) {
				return true;
			}
		}
		return false;
	}
	
	public void informarComprasTotales() {
		if(!catalogoVacio()) {
			for(int i = 0; i < compra.size(); i++) {
				System.out.println("Compra N°: " + compra.get(i).getCodigo());
				System.out.println("Fecha: " + compra.get(i).getFecha());
				System.out.println("Descripcion: " + compra.get(i).getDescripcion());
				System.out.println("Importe: " + compra.get(i).getImporte() + "\n");
			}
		}else {
			System.out.println("\nNo existen compras realizadas!\n");
		}
	}
	
	public void informarPuntosTotales(int dni) {
		for(int i = 0; i < socio.size(); i++) {
			if(socio.get(i).getDni() == dni) {
				System.out.println("\nEl socio con DNI: " + dni + " tiene --> " + socio.get(i).getPuntos() + " puntos\n");
				return;
			}
		}
	}
	
	public void aumentarPuntos(int dni, int nuevosPuntos) {
		for(int i = 0; i < socio.size(); i++) {
			if(socio.get(i).getDni() == dni) {
				for(int x = 0; x < compra.size(); x++) {
					int aumento = 0;
					if(compra.get(x).getUsuario() == dni) {
						aumento = 1;
					}
					if(aumento == 1) {
						socio.get(i).setPuntos(socio.get(i).getPuntos() + nuevosPuntos); 
						return;
					}else {
						socio.get(i).setPuntos(socio.get(i).getPuntos());
						return;
					}
				}
			}
		}
	}
}

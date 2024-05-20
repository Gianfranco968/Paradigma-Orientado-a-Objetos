package Compañia;

public class Cabotaje extends Vuelos{
	
	private int categoria;
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	@Override
	public int getCantEscala() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

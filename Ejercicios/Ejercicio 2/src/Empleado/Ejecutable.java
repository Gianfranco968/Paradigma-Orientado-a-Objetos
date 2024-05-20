package Empleado;
import Compañia.*;
import java.util.Scanner;

public class Ejecutable {
	
	private static Aerolinea aerolinea = new Aerolinea();
	private static Cabotaje cabotaje = new Cabotaje();
	private static Internacional internacional = new Internacional();
	
	public static void main(String[] args) {
		boolean verificador = true;
		Scanner leer = new Scanner(System.in);
			
		while(verificador) {
			System.out.print("----------- MENÚ -----------");
			System.out.print("\n[1] Agregar vuelo \n[2] Informar cantidad de asientos disponibles \n[3] Informar cantidad de escalas para vuelos internacionales \n[4] Salir \nOPCION: ");
			int opcion = leer.nextInt();
			
			if(opcion == 1) {
				agregarVuelos();
			}else if(opcion == 2) {
				informarAsientosDisp();
			}else if(opcion == 3) {
				informarCantEscalas();
			}else {
				verificador = false;
			}
		}
	}
	public static void agregarVuelos() {
		Scanner leer = new Scanner(System.in);
		System.out.print("\nElegir el tipo de vuelo \n[1] Cabotaje \n[2] Internacional \nOPCION: ");
		int opcion = leer.nextInt();
		
		if(opcion == 1) {
			try {
				System.out.print("\nIntroducir el número de vuelo: ");
				int vuelo = leer.nextInt();
				cabotaje.setNumeroVuelo(vuelo);
				
				System.out.print("Introducir el destino: ");
				String destino = leer.next();
				cabotaje.setDestino(destino);
				
				System.out.print("Introducir la capacidad máxima de pasajeros: ");
				int capacidad = leer.nextInt();
				cabotaje.setCapacidadMax(capacidad);
				
				System.out.print("Introducir el número de asientos ocupados: ");
				int ocupados = leer.nextInt();
				cabotaje.setAsientosOcupados(ocupados);
				
				System.out.print("Introducir la categoría del vuelo: ");
				int categoria = leer.nextInt();
				cabotaje.setCategoria(categoria);
			
				aerolinea.agregarVuelos(cabotaje);
				
				System.out.print("\n");
			}catch(java.util.InputMismatchException ex) {
				System.out.println("ERROR --> No se admiten símbolos ni letras, unicamente ingrese un número\n");
			}
						
		}else if(opcion == 2) {
			try {
				System.out.print("\nIntroducir el número de vuelo: ");
				int vuelo = leer.nextInt();
				internacional.setNumeroVuelo(vuelo);
				
				System.out.print("Introducir el destino: ");
				String destino = leer.next();
				internacional.setDestino(destino);
				
				System.out.print("Introducir la capacidad máxima de pasajeros: ");
				int capacidad = leer.nextInt();
				internacional.setCapacidadMax(capacidad);
				
				System.out.print("Introducir el número de asientos ocupados: ");
				int ocupados = leer.nextInt();
				internacional.setAsientosOcupados(ocupados);
				
				System.out.print("Introducir la cantidad de escalas: ");
				int escalas = leer.nextInt();
				internacional.setCantEscala(escalas);
			
				aerolinea.agregarVuelos(internacional);
				
				System.out.print("\n");
			}catch(java.util.InputMismatchException ex) {
				System.out.println("ERROR --> No se admiten símbolos ni letras, unicamente ingrese un número\n");
			}
		}
	}
	public static void informarAsientosDisp() {
		int asientosDisponibles = 0;
		Scanner leer = new Scanner(System.in);
		System.out.print("\nIngrese el número de vuelo: ");
		int vuelo = leer.nextInt();
		
		asientosDisponibles = aerolinea.informarAsientosDisp(vuelo);
		
		System.out.println("La cantidad de asientos disponibles para el vuelo " + vuelo + " es de: " + asientosDisponibles + "\n");
	}
	public static void informarCantEscalas() {
		Scanner leer = new Scanner(System.in);
		System.out.print("\nIngrese el número de vuelo: ");
		int vuelo = leer.nextInt();
		
		System.out.println("La cantidad de escalas para el vuelo " + vuelo + " es de " + aerolinea.informarCantEscalas(vuelo) + "\n");
	}
}

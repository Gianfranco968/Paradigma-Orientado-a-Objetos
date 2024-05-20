package empleado;

import empresa.*;	
import java.util.Scanner;

public class Ejecucion {
	
	private static Agencia agencia = new Agencia();
	private static Nacional nacional = new Nacional();
	private static Importado importado = new Importado();
	
	public static void main(String[] args) {
		
		boolean verificador = true;
		Scanner leer = new Scanner(System.in);
		
		while(verificador) {
			System.out.println("---------------------------------------------------------------- MENU ---------------------------------------------------------");
			System.out.print("Elija la opción --> \n[1] Agregar Auto \n[2] Eliminar Auto \n[3] Calcular Ganancia Individual \n[4] Calcular Ganancia Total \n[0] Salir \nOPCION: ");
			int opcionMenu = leer.nextInt();
			
			if(opcionMenu == 1) {
				agregarAuto();
			}else if(opcionMenu == 2) {
				eliminarAuto();
			}else if(opcionMenu == 3) {
				calcularGanancia();
			}else if(opcionMenu == 4) {
				calcularGananciaTotal();
			}else {
				verificador = false;
			}
		}
	}
	public static void agregarAuto() {
		
		Scanner leer = new Scanner(System.in);
		System.out.print("Elegir si se trata de --> [1] Nacional [2] Importado: ");
		int opcionTipo = leer.nextInt();
		
		if(opcionTipo == 1) {
			
			System.out.print("\nIntroducir el ID del auto: ");
			int id = leer.nextInt();
			nacional.setId(id);

			System.out.print("Introducir la marca del auto: ");
			String marca = leer.next();
			nacional.setMarca(marca);
			
			System.out.print("Introducir el modelo del auto: ");
			String modelo = leer.next();
			nacional.setModelo(modelo);
			
			System.out.print("Introducir el precio de venta del auto: ");
			double precioVenta = leer.nextDouble();
			nacional.setPrecioVenta(precioVenta);

			System.out.print("Introducir el costo de fabricacion del auto: ");
			double costoFabricacion = leer.nextDouble();
			nacional.setCostoFabricacion(costoFabricacion);
			
			agencia.agregarAuto(nacional);
			
		}else if(opcionTipo == 2) {
			System.out.print("\nIntroducir el ID del auto: ");
			int id = leer.nextInt();
			importado.setId(id);

			System.out.print("Introducir la marca del auto: ");
			String marca = leer.next();
			importado.setMarca(marca);
			
			System.out.print("Introducir el modelo del auto: ");
			String modelo = leer.next();
			importado.setModelo(modelo);
			
			System.out.print("Introducir el precio de venta del auto: ");
			double precioVenta = leer.nextDouble();
			importado.setPrecioVenta(precioVenta);

			System.out.print("Introducir el costo de fabricacion del auto: ");
			double costoFabricacion = leer.nextDouble();
			importado.setCosto(costoFabricacion);
			
			System.out.print("Introducir el valor del impuesto del auto: ");
			double impuesto = leer.nextDouble();
			importado.setImpuesto(impuesto);
			
			agencia.agregarAuto(importado);
			
		}else {
			System.out.println("ERROR --> Debe introducir una opción");
		}
	}
	public static void eliminarAuto() {
		
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Introducir el ID del auto a eliminar: ");
		int id = leer.nextInt();
		agencia.eliminarAuto(id);
		
		System.out.println("Auto eliminado con exito!");
	}
	public static void calcularGanancia() {

		double ganancia = 0;
		
		Scanner leer = new Scanner(System.in);
		System.out.print("Introducir el ID del auto a calcular su ganancia: ");
		int id = leer.nextInt();
		
		ganancia = agencia.calcularGanancia(id);
		
		System.out.println("La ganancia obtenida para el auto con ID "+ id +" es de: $"+ ganancia);
		
	}
	public static void calcularGananciaTotal() {

		double gananciaTotal = 0;
		
		gananciaTotal = agencia.calcularGananciaTotal();
				
		System.out.println("La ganancia total obtenida es de: $" + gananciaTotal);
	}
}

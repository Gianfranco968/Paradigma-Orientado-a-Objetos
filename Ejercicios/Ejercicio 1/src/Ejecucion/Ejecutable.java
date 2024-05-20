package Ejecucion;

import java.util.Scanner;
import Negocio.*;

public class Ejecutable {
	
	private static Empresa empresa = new Empresa();
	
	public static void main(String[] args) {
		
		boolean verificador = true;
		Scanner leer = new Scanner(System.in);
		
		while(verificador) {
			System.out.print("------------- MENÚ ------------\n");
			System.out.print("Elegir la opción --> \n[1] Agregar empleado \n[2] Eliminar empleado \n[3] Buscar sueldo neto empleado con DNI \n[4] Buscar empleado con mejor sueldo bruto \n[0] Salir \nOPCION: ");
			int opcion = leer.nextInt();
			
			if(opcion == 1) {
				agregarEmpleado();
			}else if(opcion == 2) {
				eliminarEmpleado();
			}else if(opcion == 3) {
				determinarSueldoNeto();
			}else if(opcion == 4) {
				empleadoMayorSueldo();
			}else {
				verificador = false;
			}
		}
	}
	public static void agregarEmpleado() {
		Empleado empleado = new Empleado();
		Scanner leer = new Scanner(System.in);
		
		System.out.print("\nIngresar el DNI (Documento Nacional Identidad) del empleado: ");
		int documento = leer.nextInt();
		empleado.setDocumento(documento);
		
		System.out.print("Ingresar el NOMBRE del empleado: ");
		String nombre = leer.next();
		empleado.setNombre(nombre);
		
		System.out.print("Ingresar el SUELDO NETO del empleado: ");
		double sueldoNeto = leer.nextDouble();
		empleado.setSueldoNeto(sueldoNeto);
		
		System.out.print("Ingresar el SUELDO BRUTO del empleado: ");
		double sueldoBruto = leer.nextDouble();
		empleado.setSueldoBruto(sueldoBruto);
		
		System.out.print("Ingresar el DOMICILIO del empleado: ");
		String domicilio = leer.next();
		empleado.setDomicilio(domicilio);
		
		empresa.agregarEmpleado(empleado);
		System.out.println("");
	}
	public static void eliminarEmpleado() {
		Scanner leer = new Scanner(System.in);
		
		System.out.print("\nIngresar el DNI del empleado para eliminarlo de la base: ");
		int documento = leer.nextInt();
		empresa.eliminarEmpleado(documento);
		
		System.out.println("Se ha eliminado el empleado de manera exitosa!\n");
	}
	public static void determinarSueldoNeto() {
		double sueldo = 0;
		Scanner leer = new Scanner(System.in);
		
		System.out.print("\nIngresar el DNI del empleado para determinar su sueldo neto: ");
		int documento = leer.nextInt();
		sueldo = empresa.determinarSueldoNeto(documento);
		
		System.out.println("El sueldo neto del empleado con DNI " + documento + " es de: " + sueldo);
	}
	public static void empleadoMayorSueldo() {
		String trabajador = "";
		trabajador = empresa.empleadoMayorSueldo();
		
		System.out.print("El empleado que más cobra es: " + trabajador);
		
	}
}

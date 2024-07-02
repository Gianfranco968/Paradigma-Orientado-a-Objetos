package Ejecutable;
import Empresa.*;
import java.util.Scanner;

public class Ejecucion {

	static Scanner leer = new Scanner(System.in);
	private static Hotel hotel = new Hotel();
	
	public static void main(String[] args) {
		
		boolean seguir = true;
		hotel.agregarHabitaciones();
		
		while(seguir) {
			System.out.println("-------------------- MENU --------------------");
			System.out.print("[1] Agregar cliente \n[2] Cancelar reserva de un cliente \n[3] Informar habitaciones disponibles \n[4] Informar reservas totales \n\nOPCION: ");
			int opcion = leer.nextInt();
			
			if(opcion == 1) {
				
				Cliente cliente = new Cliente();
				
				System.out.print("Introducir el DNI: ");
				int dni = leer.nextInt();
				if(hotel.existeCliente(dni) == false) {
					cliente.setDni(dni);
					
					System.out.print("Introducir el nombre: ");
					String nombre = leer.nextLine();
					cliente.setNombre(nombre);
					
					leer.nextLine();
					
					System.out.print("Introducir el domicilio: ");
					String domicilio = leer.nextLine();
					cliente.setDomicilio(domicilio);
					
					System.out.print("Introducir el telefono: ");
					String telefono = leer.next();
					cliente.setTelefono(telefono);
					
					hotel.agregarCliente(cliente);
					System.out.println("\nCliente agregado exitosamente!\n");
					
				}else {
					System.out.println("\nEl cliente ya existe!\n");
				}
				
				Reservas reserva = new Reservas();
				Simple simple = new Simple();
				Doble doble = new Doble();
				Matrimonial matrimonial = new Matrimonial();
				
				System.out.print("Introducir la habitacion a reservar: ");
				int habitacion = leer.nextInt();
				
				if(hotel.informarHabitacionAReservar(habitacion) == true) {
					reserva.setCliente(dni);
					reserva.setCodigo(habitacion);
					
					hotel.eliminarDisponibilidad(habitacion);
					
					while(true) {
						
						System.out.print("Introducir el tipo de habitacion \n[1] Simple \n[2] Doble \n[3] Matrimonial \n\nOPCION: ");
						int elegir = leer.nextInt();
						
						if(elegir == 1) {
							reserva.setImporte(simple.calcularPrecio());
							break;
						}else if(elegir == 2) {
							reserva.setImporte(doble.calcularPrecio());
							break;
						}else if(elegir == 3) {
							reserva.setImporte(matrimonial.calcularPrecio());
							break;
						}else {
							System.out.println("\nERROR --> Debe introducir un valor ente 1 y 3, intente nuevamente!\n");
						}
					}
					
					System.out.print("Introducir la cantidad de dias: ");
					int cantidad = leer.nextInt();
					reserva.setCantDias(cantidad);
					
					leer.nextLine();
					
					System.out.print("Introducir la fecha de comienzo: ");
					String fecha = leer.nextLine();
					reserva.setFechaComienzo(fecha);
					
					hotel.realizarReserva(reserva);
					System.out.println("\nReserva realizada exitosamente!\n");

				} else {
					System.out.println("\nLa habitacion " + habitacion + " no se encuentra disponible!\n");
				}	
				
			}else if(opcion == 2) {
				
				System.out.print("Introducir el DNI para cancelar una reserva: ");
				int dni = leer.nextInt();
				
				if(hotel.existeCliente(dni)) {
					hotel.cancelarReserva(dni);
				}else {
					System.out.println("\nEl cliente con DNI " + dni + " no existe!\n");
				}
				
			}else if(opcion == 3) {
				
				hotel.informarHabitacionesDisponibles();
				
			}else if(opcion == 4) {
				
				if(hotel.existenReservas()) {
					hotel.informarReservasTotales();
				} else {
					System.out.println("\nNo existen reservas!\n");
				}
				
			}else if(opcion == 0) {
				
				System.out.println("Programa finalizado!");
				break;
				
			}else {
				System.out.println("ERROR --> Debe introducir un valor entre 0 y 4, intente nuevamente!");
			}
		}
	}
}
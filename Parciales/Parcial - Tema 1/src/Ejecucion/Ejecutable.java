package Ejecucion;
import Negocio.*;
import java.util.Scanner;

public class Ejecutable {

	static Scanner leer = new Scanner(System.in);
	private static Cooperativa cooperativa = new Cooperativa();
	
	public static void main(String[] args) {
		boolean seguir = true;
		while(seguir) {
			
			System.out.println("-------------------- MENU --------------------");
			System.out.print("[1] Agregar socio y realizar compra \n[2] Informar compras totales de un socio \n[3] Informar puntuaje total de un socio \n[4] Informar todas las compras realizadas \n\nOPCION: ");
			int opcion = leer.nextInt();
			
			if(opcion == 1) {
				
				Socios socio = new Socios();
				Compras_con_tarjeta conTarjeta = new Compras_con_tarjeta();
				Compras_sin_tarjeta sinTarjeta = new Compras_sin_tarjeta();
				
				System.out.print("Introducir el dni del socio: ");
				int dni = leer.nextInt();
				
				if(cooperativa.existeSocio(dni) == false) {
					socio.setDni(dni);
					
					leer.nextLine();
					
					System.out.print("Introducir el nombre: ");
					String nombre = leer.nextLine();
					socio.setNombre(nombre);
										
					System.out.print("Introducir el domicilio: ");
					String domicilio = leer.nextLine();
					socio.setDomicilio(domicilio);
					
					System.out.print("Introducir el telefono: ");
					String telefono = leer.nextLine();
					socio.setTelefono(telefono);
					
					cooperativa.agregarSocio(socio);
					System.out.println("\nSocio agregado exitosamente!\n");
					
				} else {
					System.out.println("\nDicho cliente ya existe!\n");
				}
				
				System.out.print("¿Como desea pagar? \n[1] Con tarjeta \n[2] Sin tarjeta \n\nOPCION: ");
				int pago = leer.nextInt();
				
				if(pago == 1) {
					
					conTarjeta.setUsuario(dni);
					
					System.out.print("Introducir el codigo de compra: ");
					int codigo = leer.nextInt();
					conTarjeta.setCodigo(codigo);
					
					leer.nextLine();
					
					System.out.print("Introducir la descripcion: ");
					String desc = leer.nextLine();
					conTarjeta.setDescripcion(desc);
					
					System.out.print("Introducir la fecha: ");
					String fecha = leer.nextLine();
					conTarjeta.setFecha(fecha);
					
					System.out.print("Introducir el importe total: ");
					double importe = leer.nextDouble();
					conTarjeta.setImporte(importe);
					
					System.out.print("Introducir el numero de tarjeta: ");
					int numero = leer.nextInt();
					conTarjeta.setNumeroTarjeta(numero);
					
					socio.setPuntos(conTarjeta.cargarPuntos());
					int puntosActuales = socio.getPuntos();
					cooperativa.aumentarPuntos(dni, puntosActuales);
					
					cooperativa.realizarCompra(conTarjeta);
					System.out.println("\nCompra realizada exitosamente!\n");
					
				} else if(pago == 2) {
					
					sinTarjeta.setUsuario(dni);
					
					System.out.print("Introducir el codigo de compra: ");
					int codigo = leer.nextInt();
					sinTarjeta.setCodigo(codigo);
					
					System.out.print("Introducir la descripcion: ");
					String desc = leer.nextLine();
					sinTarjeta.setDescripcion(desc);
					
					leer.nextLine();
					
					System.out.print("Introducir la fecha: ");
					String fecha = leer.nextLine();
					sinTarjeta.setFecha(fecha);
					
					System.out.print("Introducir el importe total: ");
					double importe = leer.nextDouble();
					sinTarjeta.setImporte(importe);
					
					socio.setPuntos(sinTarjeta.cargarPuntos());
					int puntosActuales = socio.getPuntos();
					cooperativa.aumentarPuntos(dni, puntosActuales);
					
					cooperativa.realizarCompra(sinTarjeta);
					System.out.println("\nCompra realizada exitosamente!\n");
				}else {
					System.out.println("ERROR --> Debe seleccionar alguna de las dos opciones");
				}
				
			}else if(opcion == 2) {
				System.out.print("Introducir el DNI del socio: ");
				int dni = leer.nextInt();
				cooperativa.informarCompras(dni);
			}else if(opcion == 3) {
				System.out.print("Introducir el DNI del socio: ");
				int dni = leer.nextInt();
				cooperativa.informarPuntosTotales(dni);
			}else if(opcion == 4) {
				cooperativa.informarComprasTotales();
			}else if(opcion == 0) {
				break;
			}else {
				System.out.println("ERROR --> Introducir nuevamente una opcion entre 0 y 4!");
			}
		}
	}
}

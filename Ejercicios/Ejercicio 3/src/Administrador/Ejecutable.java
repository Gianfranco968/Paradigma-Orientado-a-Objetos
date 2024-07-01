package Administrador;
import Negocio.*;
import java.util.Scanner;

public class Ejecutable {
	
	static Scanner leer = new Scanner(System.in);
		
	public static void main(String[] args) {
		Agencia agencia = new Agencia();
		boolean seguir = true;
		
		while(seguir) {
			System.out.println("-------------------- MENU --------------------");
			System.out.print("[1] Agregar auto \n[2] Calcular ganancia de un auto \n[3] Eliminar auto \n[4] Ganancia total \n\nOPCION: ");
			int opcion = leer.nextInt();
			
			if(opcion == 1) {
				while(true)	{
					System.out.print("Introducir el tipo de auto \n[1] Importado \n[2] Nacional \n\nOPCION: ");
					int elegir = leer.nextInt();
					if(elegir == 1) {
						Autos_importados importados = new Autos_importados();
						System.out.print("Introduzca el codigo: ");
						int codigo = leer.nextInt();
						if(agencia.existeAuto(codigo) == true) {
							break;
						}else {
							importados.setCodigo(codigo);
							
							System.out.print("Introducir la marca: ");
							String marca = leer.nextLine();
							importados.setMarca(marca);
							
							leer.nextLine();
							
							System.out.print("Introducir el modelo: ");
							String modelo = leer.nextLine();
							importados.setModelo(modelo);
							
							System.out.print("Introducir el precio de venta: ");
							double precio = leer.nextDouble();
							importados.setPrecioVenta(precio);
							
							System.out.print("Introducir el valor del impuesto: ");
							double impuesto = leer.nextDouble();
							importados.setImpuesto(impuesto);

							System.out.print("Introducir el costo de fabricacion: ");
							double costo = leer.nextDouble();
							importados.setCostoFabricacion(costo);
							
							agencia.agregarAuto(importados);
							System.out.println("Auto agregado exitosamente!");
							break;
						}
					}else if(elegir == 2) {
						Autos_nacionales nacionales = new Autos_nacionales();
						System.out.print("Introduzca el codigo: ");
						int codigo = leer.nextInt();
						if(agencia.existeAuto(codigo)) {
							break;
						}else {
							nacionales.setCodigo(codigo);
							
							System.out.print("Introducir la marca: ");
							String marca = leer.nextLine();
							nacionales.setMarca(marca);
							
							leer.nextLine();
							
							System.out.print("Introducir el modelo: ");
							String modelo = leer.nextLine();
							nacionales.setModelo(modelo);
							
							System.out.print("Introducir el precio de venta: ");
							double precio = leer.nextDouble();
							nacionales.setPrecioVenta(precio);
							
							System.out.print("Introducir el valor del impuesto: ");
							double impuesto = leer.nextDouble();
							nacionales.setImpuesto(impuesto);
							
							System.out.print("Introducir el costo de fabricacion: ");
							double costo = leer.nextDouble();
							nacionales.setCostoFabricacion(costo);
							
							agencia.agregarAuto(nacionales);
							System.out.println("Auto agregado exitosamente!");
							break;
						}
					}else {
						System.out.println("\nDebe introducir un valor entre 1 y 2!\n");
					}
				}
			}else if(opcion == 2) {
				double ganancia = 0;
				System.out.print("Introducir el codigo del auto para calcular su ganancia: ");
				int codigo = leer.nextInt();
				ganancia = agencia.calcularGanacia(codigo);
				
				System.out.println("\nLa ganancia del auto con ID " + codigo + " es de: $" + ganancia + "\n");
			}else if(opcion == 3) {
				System.out.print("Introducir el codigo del auto para eliminar: ");
				int codigo = leer.nextInt();
				agencia.eliminarAuto(codigo);
			}else if(opcion == 4) {
				agencia.calcularGananciaTotal();
			}
		}
	}
}

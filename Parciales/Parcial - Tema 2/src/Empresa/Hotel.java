package Empresa;
import java.util.ArrayList;

public class Hotel {

	private ArrayList<Cliente> cliente;
	private ArrayList<Integer> habitacion = new ArrayList<>();
	private ArrayList<Reservas> reserva;
	
	public Hotel() {
		cliente = new ArrayList<Cliente>();
		reserva = new ArrayList<Reservas>();
	}
	
	public void agregarHabitaciones() {
		for(int i = 1; i <= 20; i++) {
			habitacion.add(i);
		}
	}
	
	public void agregarCliente(Cliente c) {
		cliente.add(c);
	}
	
	public void realizarReserva(Reservas r) {
		reserva.add(r);
	}
	
	public void cancelarReserva(int dni) {
		for(int i = 0; i < reserva.size(); i++) {
			if(reserva.get(i).getCliente() == dni) {
				int habitacionACargar = reserva.get(i).getCodigo();
				habitacion.add(habitacionACargar);
				reserva.remove(i);
				System.out.println("\nReserva cancelada exitosamente!\n");
				return;
			}
		}
	}
	
	public void informarHabitacionesDisponibles() {
		System.out.println("Las habitaciones disponibles son las siguientes: ");
		for(int i = 0; i < habitacion.size(); i++) {
			System.out.print(habitacion.get(i) + " ");
		}
		System.out.println("\n");
	}
	
	public void informarReservasTotales() {
		for(int i = 0; i < reserva.size(); i++) {
			System.out.println("Codigo de reserva: " + reserva.get(i).getCodigo());
			System.out.println("Fecha de comienzo: " + reserva.get(i).getFechaComienzo());
			System.out.println("Importe: $" + reserva.get(i).getImporte());
			System.out.println("Cantidad de dias: " + reserva.get(i).getCantDias() + "\n");
		}
	}
	
	public boolean existeCliente(int dni) {
		for(int i = 0; i < cliente.size(); i++) {
			if(cliente.get(i).getDni() == dni) {
				return true;
			}
		} return false;
	}
	
	public boolean informarHabitacionAReservar(int h) {
		for(int i = 0; i < habitacion.size(); i++) {
			if(habitacion.get(i) == h) {
				return true;
			}
		} return false;
	}
	
	public void eliminarDisponibilidad(int h) {
		for(int i = 0; i < habitacion.size(); i++) {
			if(habitacion.get(i) == h) {
				habitacion.remove(i);
				return;
			}
		}
	}
	
	public boolean existenReservas() {
		if(reserva.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}
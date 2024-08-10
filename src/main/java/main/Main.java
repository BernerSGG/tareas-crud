package main;

import java.util.Scanner;
import dao.selectDao;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Creando un nuevo estudiante...");

		String nombre = "helen";
		String apellido = "rodas";
		String fecha_nacimiento = "2004-06-02";
		String genero = "F";
		String direccion = "Calle 10, Ciudad";
		String telefono = "555-866";
		String correo_electronico = "helen.rodas@example.com";
		String grado = "Segundo";
		String fecha_inscripcion = "2024'0i¿}-01-16";

		boolean exitoCrear = selectDao.crearEstudiante(nombre, apellido, fecha_nacimiento, genero, direccion, telefono,
				correo_electronico, grado, fecha_inscripcion);

		if (exitoCrear) {
			System.out.println("Estudiante creado exitosamente.");
		} else {
			System.out.println("Error al crear el estudiante.");
		}

		System.out.println("\nActualizando un estudiante...");

		System.out.print("Ingrese el ID del estudiante a actualizar: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Ingrese el nombre del estudiante: ");
		nombre = scanner.nextLine();

		System.out.print("Ingrese el apellido del estudiante: ");
		apellido = scanner.nextLine();

		System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
		fecha_nacimiento = scanner.nextLine();

		System.out.print("Ingrese el género del estudiante: ");
		genero = scanner.nextLine();

		System.out.print("Ingrese la dirección del estudiante: ");
		direccion = scanner.nextLine();

		System.out.print("Ingrese el teléfono del estudiante: ");
		telefono = scanner.nextLine();

		System.out.print("Ingrese el correo electrónico del estudiante: ");
		correo_electronico = scanner.nextLine();

		System.out.print("Ingrese el grado del estudiante: ");
		grado = scanner.nextLine();

		System.out.print("Ingrese la fecha de inscripción (YYYY-MM-DD): ");
		fecha_inscripcion = scanner.nextLine();

		boolean exitoActualizar = selectDao.actualizarEstudiante(id, nombre, apellido, fecha_nacimiento, genero,
				direccion, telefono, correo_electronico, grado, fecha_inscripcion);

		if (exitoActualizar) {
			System.out.println("Estudiante actualizado exitosamente.");
		} else {
			System.out.println("Error al actualizar el estudiante.");
		}

		System.out.println("\nEliminando un estudiante...");

		System.out.print("Ingrese el ID del estudiante a eliminar: ");
		int idEliminar = scanner.nextInt();

		boolean exitoEliminar = selectDao.eliminarEstudiante(idEliminar);

		if (exitoEliminar) {
			System.out.println("Estudiante eliminado exitosamente.");
		} else {
			System.out.println("Error al eliminar el estudiante.");
		}

		scanner.close();
	}
}

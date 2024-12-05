package es.unileon.prg2.patterns;

import es.unileon.prg2.patterns.builder.*;
import es.unileon.prg2.patterns.composite.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir la ruta del archivo al usuario
        System.out.println("Introduce la ruta del archivo CSV:");
        String filePath = scanner.nextLine();

        // Crear el builder y el director
        ElectionsBuilder builder = new ElectionsConcreteBuilder();
        ElectionsDirector director = new ElectionsDirector(builder);

        // Intentar construir el árbol desde el CSV
        try {
            director.build(filePath);

            // Obtener el resultado y mostrarlo (o manejarlo según sea necesario)
            ElectionsComponent result = builder.getResult();
            if (result != null) {
                System.out.println("Árbol construido correctamente:");
                System.out.println(result.toString());
            } else {
                System.out.println("El árbol no se pudo construir. Verifica el archivo CSV.");
            }
        } catch (Exception e) {
            System.err.println("Error al construir el árbol de elecciones:");
            e.printStackTrace();
        }

        // Cerrar el escáner
        scanner.close();
    }
}

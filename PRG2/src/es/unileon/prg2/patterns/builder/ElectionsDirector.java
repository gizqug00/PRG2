package es.unileon.prg2.patterns.builder;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.Name;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ElectionsDirector {

    private ElectionsBuilder builder;

    public ElectionsDirector(ElectionsBuilder builder) {
        this.builder = builder;
    }

    public void build(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    // Dividir y validar cada línea
                    String[] parts = line.split(";");
                    if (parts.length < 6) {
                        System.err.println("Línea inválida en CSV: " + line);
                        continue; // Ignorar líneas inválidas
                    }

                    // Parsear los valores
                    String countryName = parts[0].trim();
                    String regionName = parts[1].trim();
                    String provinceName = parts[2].trim();
                    String munincipeName = parts[3].trim();
                    String districtName = parts[4].trim();
                    String electoralTableName = parts[5].trim();
                    String sectionName = parts[6].trim();
                    int maxVotes = Integer.parseInt(parts[7].trim());

                    // Construir el árbol
                    builder.addCountry(new Name(countryName));
                    builder.addRegion(new Name(regionName));
                    builder.addProvince(new Name(provinceName));
                    builder.addMunincipe(new Name(munincipeName));
                    builder.addDistrict(new Name(districtName));
                    builder.addSection(new Name(sectionName));
                    builder.addElectoralTableWithVotes(new Name(electoralTableName), maxVotes);

                } catch (CompositeException | NumberFormatException e) {
                    // Manejo de errores específicos al procesar una línea
                    System.err.println("Error procesando la línea: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // Manejo de errores de lectura del archivo
            System.err.println("Error leyendo el archivo CSV: " + filePath);
            e.printStackTrace();
        }
    }
}

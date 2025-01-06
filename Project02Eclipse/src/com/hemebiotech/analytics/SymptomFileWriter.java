package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// implemente ISymptomWriter pour écrire les symptomes

public class SymptomFileWriter implements ISymptomWriter {
    private String filepath;
    
// constructeur pour initialiser le chemin du fichier 
    
    public SymptomFileWriter(String filepath) {
        this.filepath = filepath;
    }

    // ecrit les symptomes et leurs occurences dans le fichier 
    
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
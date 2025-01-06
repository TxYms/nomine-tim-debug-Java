package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// implementation de ISymptomReader pour lire les symptomes
public class SymptomFileReader implements ISymptomReader {
    private String filepath;

    // constructeur qui initialise le chemin du fichier
    public SymptomFileReader(String filepath) {
        this.filepath = filepath;
    }

    // lit les symptomes 
    public List<String> readSymptoms() {
        List<String> symptoms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptoms.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return symptoms;
    }
}
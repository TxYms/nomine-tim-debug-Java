package com.hemebiotech.analytics;

import java.util.*;

// AnalyticsCounter lit les symptomes depuis un fichier soure pour les retranscrire dans un fichier de sortie 

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	// reader implemente ISymptomReader pour lire les symptomes 
	// writer implemente ISymptomWriter pour écrire les symptomes 
	   
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
		
	}
	
	// Lit les symptomes depuis le fichier source 
	
	public List<String> getSymptoms() {		
		return reader.readSymptoms();
	
	}
	
	// compte le nombre de symptom dans le fichier 
			
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        symptoms.forEach(symptom -> symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1));
        return symptomCounts;
    }
	
	// trie les symptomes par ordre alphabétique grace a TreeMap

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }
    
    // Ecrit les symptomes et leur nombre dans le fichier de sortie 

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
    
    // implemente ISymptomReader et ISymptomWriter pour traiter les fichiers d'entrée et de sortie 

    public static void main(String[] args) {
        ISymptomReader reader = new SymptomFileReader("symptoms.txt");
        ISymptomWriter writer = new SymptomFileWriter("result.out.txt");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        
        List<String> symptoms = analyticsCounter.getSymptoms(); 
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms); 
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms); 
        analyticsCounter.writeSymptoms(sortedSymptoms);
       
        
    }
    
}

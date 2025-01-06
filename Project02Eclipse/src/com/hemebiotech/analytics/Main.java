package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		String inputFile = "symptom.txt";
		String outputFile = "result.out.txt";
		
		// instanciation pour lire les fichiers depuis symptom.txt
		ISymptomReader reader = new SymptomFileReader(inputFile);
		
		//instanciation pour ecrire les resultats dans result.out
		ISymptomWriter writer = new SymptomFileWriter(outputFile);
		
		//traitement des symptomes
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		
		// lecture des symtpomes
		 List<String> symptoms = analyticsCounter.getSymptoms();
		 
		 // comptage des symptomes
		 Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
		 
		 // tri des symptomes
		 Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);
		 
		 //ecriture des resultats 
		 analyticsCounter.writeSymptoms(sortedSymptoms);
		 
		 System.out.println("Traitement terminé");
		 
		 
	}
}
		
		
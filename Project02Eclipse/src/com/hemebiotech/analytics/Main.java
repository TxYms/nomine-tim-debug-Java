package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		// instanciation pour lire les fichiers depuis input.txt
		ISymptomReader reader = new SymptomFileReader("input.txt");
		
		//instanciation pour ecrire les resultats dans output.txt
		ISymptomWriter writer = new SymptomFileWriter("output.txt");
		
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
		
		
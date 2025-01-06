package com.hemebiotech.analytics;

import java.util.Map;

//L'interface définit une méthode pour ecrire les symptomes dans un fichier de sortie 

public interface ISymptomWriter {
	
	// écrit les symptomes dans un fichier 
	
	 public void writeSymptoms(Map<String, Integer> symptoms);
	

}

package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

//L'interface définit une méthode pour ecrire les symptomes dans un fichier de sortie 

public interface ISymptomWriter {
	
	// écrit les symptomes dans un fichier 
	
	 public void writeSymptoms(Map<String, Integer> symptoms);

	//récupère une liste de symptome
	
	List<String> writeSymptoms();
	

}

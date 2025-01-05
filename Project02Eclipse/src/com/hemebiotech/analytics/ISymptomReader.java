package com.hemebiotech.analytics;

import java.util.List;

// l'inteface définit une méthode pour lire une liste de symptomes depuis un fichier source

public interface ISymptomReader {
	
	// Lit les symtpomes depuis un fichier source
	
	
	List<String> readSymptoms ();

}

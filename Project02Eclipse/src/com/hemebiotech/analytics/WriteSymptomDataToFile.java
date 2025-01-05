package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class WriteSymptomDataToFile implements ISymptomWriter{
	
private String filepath;
	
	// initialise le chemin du fichier a lire grace a (filepath)

	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	// Lit les symptomes depuis le fichier source 
	//si aucune reponse n'est trouvé alors cela affichera (null)
	
	public List<String> writeSymptoms() {
		List<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader("result.out"));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

} 



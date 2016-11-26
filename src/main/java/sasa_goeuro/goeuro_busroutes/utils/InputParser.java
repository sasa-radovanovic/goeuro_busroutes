package sasa_goeuro.goeuro_busroutes.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.IntStream;

import sasa_goeuro.goeuro_busroutes.DataRepository;

/**
 * 
 * Input parser used to parse file data
 * 
 * @author Sasa Radovanovic
 *
 */
public class InputParser {
	
	private static InputParser inputParser;
	
	private int linesParsed = 0;
	
	private InputParser () {
	}
	
	/**
	 * 
	 * Get an instance of InputParser (this)
	 * 
	 * @return @InputParser instance
	 */
	public static InputParser getInstance () {
		if (inputParser == null) {
			inputParser = new InputParser();
		}
		return inputParser;
	}
	
	/**
	 * 
	 * Parse file content and store it in @DataRepository
	 * 
	 * @param filePath - path of the file on the File System
	 */
	public void parseFile (String filePath) {

		try (BufferedReader br=Files.newBufferedReader(Paths.get(filePath))) {
		    String firstLine=br.readLine();
		    
		    // Could not extract first line
		    if (firstLine == null) {
		    	throw new IOException();
		    }
		    
		    int numOfLines = Integer.parseInt(firstLine);
		    
		    // Parse all other lines
		    br.lines().forEach(line -> {
		    	
		    	// Separate by " " 
		    	String[] lineElements = line.split(" ");
		    	
		    	// Go through one line station array and store data
		    	// If one line has N stations, start from first one and store all the others as direct connections
		    	// Move to second, third... until N-1
		    	IntStream.range(1, lineElements.length - 1).forEach(i -> {
		    		IntStream.range(i + 1, lineElements.length).forEach(i2 -> {
		    			addPair(Integer.parseInt(lineElements[i]), Integer.parseInt(lineElements[i2]));
		    		});
		    	});
		    	
		    	// Just additional check if the file contains more than declared lines
		    	linesParsed ++;
		    	if (linesParsed == numOfLines) {
		    		return;
		    	}
		    });
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 * Method to insert data into @DataRepository
	 * 
	 * @param startingStation - starting station
	 * @param endingStation - direct-connecting station
	 */
	private void addPair (int startingStation, int endingStation) {
		ArrayList<Integer> connections;
		// If there starting station in the repository
		if (DataRepository.routeConnections.containsKey(startingStation)) {
			// Get it's direct connections
			connections = DataRepository.routeConnections.get(startingStation);
			// Do not duplicate entries
			if (!connections.contains(endingStation)) {
				// Add new connection
				connections.add(endingStation);
			}
		// If there is no entry in the repository, create new one
		} else {
			connections = new ArrayList<>();
			connections.add(endingStation);
			DataRepository.routeConnections.put(startingStation, connections);
		}
	}

}

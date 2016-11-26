package sasa_goeuro.goeuro_busroutes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Data Repository for holding collection consisting of station connections
 * 
 * @author Sasa Radovanovic
 *
 */
public class DataRepository {
	
	// HashMap -> stationId : ArrayList of all stationIds with direct connection
	public static HashMap<Integer, ArrayList<Integer>> routeConnections = new HashMap<>();

}

package sasa_goeuro.goeuro_busroutes.services;

import sasa_goeuro.goeuro_busroutes.DataRepository;

/**
 * 
 * Service for handling business logic
 * 
 * @author Sasa Radovanovic
 *
 */
public class RouteService {


	/**
	 * 
	 * Check if there is direct connection between two stations
	 * 
	 * @param startingStation - "from" station
	 * @param endingStation - "to" station
	 * @return
	 */
	public static boolean hasDirectConnection (int startingStation, int endingStation) {
		try {
			return DataRepository.routeConnections.get(startingStation).contains(endingStation);
		} catch (Exception e) {
			return false;
		}
	}

}

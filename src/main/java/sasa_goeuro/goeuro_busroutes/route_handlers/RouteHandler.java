package sasa_goeuro.goeuro_busroutes.route_handlers;

import sasa_goeuro.goeuro_busroutes.entities.ResponseEntity;
import sasa_goeuro.goeuro_busroutes.services.RouteService;

/**
 * 
 * HTTP request handler for handling Route functionalities
 * In an real-world scenarion - we would separate different functionalities into
 * different handlers, i.e. User routes starting with /user/* would be handled by
 * UserHandler, GeoLocation routes starting with /location/* would be handled by
 * LocationHandler, etc...
 * 
 * @author Sasa Radovanovic
 *
 */
public class RouteHandler {
	
	/**
	 * 
	 * Handler direct route check request
	 * 
	 * @param departure - ID of departure station
	 * @param arrival - ID of arrival station
	 * @return - direct connection or not
	 */
	public static ResponseEntity handleRouteRequest (int departure, int arrival) {
		return new ResponseEntity(departure, arrival, RouteService.hasDirectConnection(departure, arrival));
	}

}

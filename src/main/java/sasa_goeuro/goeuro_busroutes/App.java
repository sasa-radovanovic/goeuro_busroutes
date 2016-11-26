package sasa_goeuro.goeuro_busroutes;
import static spark.Spark.*;
import static sasa_goeuro.goeuro_busroutes.utils.JsonUtil.*;

import java.io.IOException;

import sasa_goeuro.goeuro_busroutes.route_handlers.RouteHandler;
import sasa_goeuro.goeuro_busroutes.utils.InputParser;

/**
 * 
 * Main application file
 * 
 * @author Sasa Radovanovic
 *
 */
public class App {
	public static void main( String[] args ) throws IOException {

		// Get instance of @InputParser used to extract data from file and 
		// store it in @DataRepository
		InputParser inputParser = InputParser.getInstance();
		
		// When no input file is provided
		if (args.length == 0) {
			throw new IOException("NO INPUT FILE PROVIDED");
		}
		
		inputParser.parseFile(args[0]);
		
		port(8088);
		
		// If exception is thrown - wrong arguments [Couldn't be parsed to Integer]
		exception(Exception.class, (e, req, res) -> {
			res.status(400);
			res.body("Wrong arguments");
		});

		// Handle route
		get("/api/direct", (req, res) -> {
				int depS_id = Integer.parseInt(req.queryParams("dep_sid"));
				int arrS_id = Integer.parseInt(req.queryParams("arr_sid"));
				return RouteHandler.handleRouteRequest(depS_id, arrS_id);
		}, json());

		// Set content type of the response
		after((req, res) -> {
			res.type("application/json");
		});
	}
}

package sasa_goeuro.goeuro_busroutes.utils;

import spark.ResponseTransformer;

import com.google.gson.Gson;

/**
 * 
 * Util class for transforming data into JSON
 * 
 * @author Sasa Radovanovic
 *
 */
public class JsonUtil {

	public static String toJson(Object object) {
		return new Gson().toJson(object);
	}

	public static ResponseTransformer json() {
		return JsonUtil::toJson;
	}
}
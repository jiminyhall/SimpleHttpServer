package com.jch;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author jch
 *
 */
@SuppressWarnings("restriction")
public class HttpRequestHandler implements HttpHandler {

	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String DESC = "desc";
	private static final String DATE = "date";

	private static final int PARAM_NAME_IDX = 0;
	private static final int PARAM_VALUE_IDX = 1;

	private static final int HTTP_OK_STATUS = 200;

	private static final String AND_DELIMITER = "&";
	private static final String EQUAL_DELIMITER = "=";

	public int count = 0;

	public void handle(HttpExchange t) throws IOException {

		//Create a response form the request query parameters
		URI uri = t.getRequestURI();
		String response = createResponseFromQueryParams(uri);
		System.out.println("Response: " + response);
		//Set the response header status and length
		t.sendResponseHeaders(HTTP_OK_STATUS, response.getBytes().length);
		//Write the response string
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

	/**
	 * Creates the response from query params.
	 *
	 * @param uri the uri
	 * @return the string
	 */
	private String createResponseFromQueryParams(URI uri) {

		count++;
		String id = "";
		String title = "";
		String desc = "";
		String date = "";
		//Get the request query
		String query = uri.getQuery();
		if (query != null) {
			System.out.println("Query: " + query);
			String[] queryParams = query.split(AND_DELIMITER);
			if (queryParams.length > 0) {
				for (String qParam : queryParams) {
					String[] param = qParam.split(EQUAL_DELIMITER);
					if (param.length > 0) {
						for (int i = 0; i < param.length; i++) {
							if (ID.equalsIgnoreCase(param[PARAM_NAME_IDX])) {
								id = param[PARAM_VALUE_IDX];
							}
							if (TITLE.equalsIgnoreCase(param[PARAM_NAME_IDX])) {
								title = param[PARAM_VALUE_IDX];
							}
							if (DESC.equalsIgnoreCase(param[PARAM_NAME_IDX])) {
								dsec = param[PARAM_VALUE_IDX];
							}
							if (DATE.equalsIgnoreCase(param[PARAM_NAME_IDX])) {
								date = param[PARAM_VALUE_IDX];
							}
						}
					}
				}
			}
		}

		return "Hello, " + fName + " " + lName + ". " + count + " time(s)";
	}
}

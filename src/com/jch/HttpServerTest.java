package com.jch;


/**
 * When GET, all form data is encoded into the URL, appended to the action URL as query string parameters.
 * With POST, form data appears within the message body of the HTTP request.
*/

/**
 * @author jch
 *
 */
public class HttpServerTest {

	private static final String CONTEXT = "/tasks";
	private static final int PORT = 8000;

	public static void main(String[] args) throws Exception {

		// Create a new SimpleHttpServer
		SimpleHttpServer simpleHttpServer = new SimpleHttpServer(PORT, CONTEXT,	new HttpRequestHandler());

		// Start the server
		simpleHttpServer.start();
		System.out.println("Server is started and listening on port "+ PORT);

    simpleHttpServer.sendPost(CONTEXT, PORT, "1", "item1", "the first item", "01/03/1981");
    simpleHttpServer.sendPost(CONTEXT, PORT, "2", "item2", "the second item", "01/03/1992");
    simpleHttpServer.sendPost(CONTEXT, PORT, "3", "item3", "the third item", "01/03/2003");

		// TO IMPLEMENT // simpleHttpServer.sendGet(CONTEXT, PORT, obj4);
		// TO IMPLEMENT // simpleHttpServer.sendGet(CONTEXT, PORT, obj5);

		// TO IMPLEMENT // simpleHttpServer.sendGet(CONTEXT, PORT, "1");
		// TO IMPLEMENT // simpleHttpServer.sendGet(CONTEXT, PORT, "5");

		// TO IMPLEMENT // simpleHttpServer.delete(CONTEXT, PORT, "5");

    simpleHttpServer.stop();

	}

}

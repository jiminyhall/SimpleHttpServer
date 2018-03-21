package com.jch;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.*;
import java.io.*;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("restriction")
public class SimpleHttpServer {

	private HttpServer httpServer;

	/**
	 * Instantiates a new simple http server.
	 *
	 * @param port the port
	 * @param context the context
	 * @param handler the handler
	 */
	public SimpleHttpServer(int port, String context, HttpHandler handler) {
		try {
			//Create HttpServer which is listening on the given port
			httpServer = HttpServer.create(new InetSocketAddress(port), 0);
			//Create a new context for the given context and handler
			httpServer.createContext(context, handler);
			//Create a default executor
			httpServer.setExecutor(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Start.
	 */
	public void start() {
		this.httpServer.start();
	}


  /**
	 * Stop.
	 */
	public void stop() {
		this.httpServer.stop(200);
	}

  /**
   * Sends a post request
   *
   * 1, PORT, "item1", "the first item", "01/03/1981"
   *
   * @param id identification
   * @param port the PORT
   * @param title title of item1
   * @param desc the description
   * @param date the date
   */
  public static void sendPost(string CONTEXT, int PORT, String id, String title, String desc, String date) throws Exception {

    String url = "http://localhost:" + PORT + CONTEXT;
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

    String urlParameters = "id="+id+"&title="+title+"&desc="+desc+"&date="+date;

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(urlParameters);
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + urlParameters);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();

    //print result
    System.out.println(response.toString());

  }


}

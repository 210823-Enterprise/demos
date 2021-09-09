package com.revature;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {
	
	private static final String INPUT_FILE = "C:\\Users\\SophieGavrila\\Desktop\\demos\\week3\\ThroughputHttpServer\\src\\main\\resources\\war_and_peace.txt";

	// this is the variable passed to an executor to control thread pool size
	private static final int NUMBER_OF_THREADS = 4;
	
	
	public static void main(String[] args) throws IOException {
		
		// Save the content of the file into a String obj in the heap

		String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
			// the above method returns a byte array of the text file

		// we will create some method called startServer() and pass the text to the server
		startServer(text);
	
	}
	
	public static void startServer(String text) throws IOException {
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		// look up Spark Java MicroFramework
		
		server.createContext("/search", new WordCountHandler(text));
		
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		// pass the executor to the server
		server.setExecutor(executor);
		
		server.start();
		
	}
	
	
	private static class WordCountHandler implements HttpHandler {

		String text;
		
		public WordCountHandler(String text) {
			super();
			this.text = text;
		}

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			
			// capture the query from the client (this is what you see in the address bar of a browser)
			
			String query = httpExchange.getRequestURI().getQuery();
			
			// split the query up, and deduce the exact work that the user is looking for 
			String[] keyValue = query.split("="); // split up the 2 values that are on either side of the = 
			String action = keyValue[0]; // this SHOULD be word
			String word = keyValue[1];
			
			if(!action.equals("word")) {
				httpExchange.sendResponseHeaders(400, 0); // 400 level  indicates CLIENT SIDE error (you passes in an action that we don't account for) 
				return; // end the method NOW!!!! (if there's an error)
				
			}
			
			// trigger a countWord() method to find out how many times it appears within the text
			String count = countWord(word);
			
			// then return some message like " x appears y times in the text" as an HTTP response (from countWord)
			// this HTTP response will appear on the browser
			byte[] response = count.getBytes();
			httpExchange.sendResponseHeaders(200, response.length);	
			
			// return the reponse in some OutPut stream to the borwser (client)
			OutputStream outputStream = httpExchange.getResponseBody();
			
			outputStream.write(response);
			
			outputStream.close();
		}
		
		private String countWord(String word) {
			
			System.out.println("countWord() method triggered");
			
			long count = 0;
			int index = 0;
			
			while (index >= 0 ) {
				
				index = text.indexOf(word, index);
				
				// if the index is positive we found the word in the book
				if (index >= 0) {
					
					count++;
					index++;
				}
			}

			//return the message in the form of a string to be passed to handle();
			return "The word \"" + word + "\" appeared " + count + " times";
		}		
	}
	
}














package com.java.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Server {

	ServerSocket sc;

	public Server(ServerSocket sc) {
		this.sc = sc;
	}

	public void serverStart() {
		try {
			while (!sc.isClosed()) {
				Socket accept = sc.accept();
				System.out.println("New Friend connected");
				ClientHandler handler = new ClientHandler(accept);
				new Thread(handler).start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		sc.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket sc= new ServerSocket(8000);
		Server server = new Server(sc);
		server.serverStart();
	}
}

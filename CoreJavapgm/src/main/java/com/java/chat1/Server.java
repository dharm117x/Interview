package com.java.chat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static BufferedReader reader;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Server started...");
		ServerSocket ss = new ServerSocket(9000);
		while (!ss.isClosed()) {
			Runnable w = () -> {
				Socket sc = null;
				try {
					sc = ss.accept();
					reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
					System.out.println("MSG" + reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
					close(sc);
				}
			};
			new Thread(w).start();

		}

		ss.close();
	}

	private static void close(Socket sc) {
		try {
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

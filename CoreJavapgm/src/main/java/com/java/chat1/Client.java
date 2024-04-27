package com.java.chat1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	BufferedWriter writer;
	BufferedReader reader;
	Socket sc;
	String name;

	public Client(Socket sc, String name) {
		this.sc = sc;
		this.name = name;
	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		String name = args[0];
		System.out.println("Clinet started..." + name);
		Socket sc = new Socket("localhost", 9000);
		Client cl = new Client(sc, name);
		System.out.println("Input...");
		Scanner data = new Scanner(System.in);
		String msg = data.nextLine();
		cl.sendMessage(msg);
		Thread.sleep(1000);
		cl.readMessage();
	}
	
	public void sendMessage(String msg) {
		Runnable w = () -> {
			while (sc.isConnected()) {
				try {
					writer = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
					writer.write(name+ " <----> "+msg);
					writer.newLine();
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
					close(sc);
				}
			}
		};
		new Thread(w).start();
	}

	public void readMessage() {
		Runnable r = () -> {
			try {
				while (sc.isConnected()) {
					reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
					String message = reader.readLine();
					System.out.println("MSG:: " + message);
				}
			} catch (IOException e) {
				e.printStackTrace();
				close(sc);
			}
		};
		new Thread(r).start();
	}
	

	private static void close(Socket sc) {
		try {
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

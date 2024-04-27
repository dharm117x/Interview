package com.java.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket sc;
	String name;
	BufferedReader reader;
	BufferedWriter writer;

	public Client(Socket sc, String name) throws IOException {
		this.sc = sc;
		this.name = name;
		writer = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
		reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
	}

	private void sendMessage() {
		try {

			writer.write(name);
			writer.newLine();
			writer.flush();

			Scanner s = new Scanner(System.in);
			while (sc.isConnected()) {
				String line = s.nextLine();
				writer.write(name+"--------"+line);
				writer.newLine();
				writer.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void readMessage() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (sc.isConnected()) {
					try {
						String msgFromChat = reader.readLine();
						System.out.println(msgFromChat);
					} catch (IOException e) {
					}
				}

			}
		}).start();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter ur name:");
		Socket sc = new Socket("localhost", 8000);
		Client cl = new Client(sc, s.nextLine());
		cl.readMessage();
		cl.sendMessage();
	}
}

package com.java.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {

	List<ClientHandler> hadlers = new ArrayList<>();
	Socket sc;
	String name;
	BufferedReader reader;
	BufferedWriter writer;

	public ClientHandler(Socket sc) {
		this.sc = sc;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			hadlers.add(this);
			name = reader.readLine();
			brodcastMessage(name);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		String clinetmsg;

		while (sc.isConnected()) {
			try {
				clinetmsg = reader.readLine();
				brodcastMessage(clinetmsg);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

		}
	}

	private void brodcastMessage(String message) {
		for (ClientHandler clientHandler : hadlers) {
			try {
				if (!clientHandler.name.equals(name)) {
					clientHandler.writer.write(message);
					clientHandler.writer.newLine();
					clientHandler.writer.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

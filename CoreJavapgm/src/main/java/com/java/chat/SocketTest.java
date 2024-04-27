package com.java.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	static BufferedWriter writer;
	static BufferedReader reader;

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9000);

		Runnable w = () -> {
			while (!ss.isClosed()) {
				Socket sc =null;
				try {
					sc = ss.accept();
					writer = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
					Scanner data = new Scanner(System.in);
					String msg = data.nextLine();

					writer.write(msg);
					writer.newLine();
					writer.flush();

					data.close();
				} catch (IOException e) {
					e.printStackTrace();
					close(sc);
				}
			}
		};

		Runnable r = () -> {
			Socket sc = null;
			try {
				sc = new Socket("localhost", 9000);
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
		new Thread(w).start();
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

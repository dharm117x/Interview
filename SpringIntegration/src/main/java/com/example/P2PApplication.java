package com.example;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class P2PApplication {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(P2PIntegrationConfig.class);
		context.registerShutdownHook();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter q and press <enter> to exit the program: ");

		while (true) {
			String input = scanner.nextLine();
			if ("q".equals(input.trim())) {
				break;
			}
		}
		System.exit(0);
	}
}

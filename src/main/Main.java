package main;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {

		login();

	}

	public static void login() {

		System.out.println("**** Welcome to the Management System ****");

		Unity ic = new Unity();

		while(true) {

			System.out.println("Select the option:");
			System.out.printf("[1] Login%n[2] Register");
			int option = input.nextInt();

			if(option == 1) {
				ic.validate_user();
			}else {
				ic.register();
			}

		}

	}














}

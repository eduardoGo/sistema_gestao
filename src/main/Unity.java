package main;
import java.util.ArrayList;
import java.util.Scanner;

import enums.Status;


import User.GraduationStudent;
import User.Manager;
import User.MasteringStudent;
import User.PhdStudent;
import User.Researcher;
import User.Teacher;
import User.User;
import DateHour.Date;
import DateHour.Hour;
import Recursos.Auditorio;
import Recursos.Laboratorio;
import Recursos.Projetor;
import Recursos.SalaAula;
import others.Activity;
import others.GeneralReport;
import others.Request;

public class Unity {

	private static Scanner input = new Scanner(System.in);
	private ArrayList<User> usersRegistered = new ArrayList<User>();
	private static ArrayList<Request> requests = new ArrayList<Request>();

	private Auditorio auditorium = new Auditorio();
	private Projetor projector = new Projetor();
	private Laboratorio laboratory = new Laboratorio();
	private SalaAula classroom = new SalaAula();

	GeneralReport generalReport = new GeneralReport(4);

	public void register() {
		usersRegistered.add( newUser(usersRegistered.size() + 1));

	}
	public void validate_user() {

		System.out.print("User: ");
		String userLogin = input.next();
		System.out.print("Password: ");
		String passwordLogin = input.next();

		boolean verification = false;
		User userCurrentLogin = null;
		for(User userCurrentAux : usersRegistered) {
			if(userCurrentAux.getLogin().equals(userLogin))
				if(userCurrentAux.getPassword().equals(passwordLogin)) {
					verification = true;
					userCurrentLogin = userCurrentAux;
					break;
				}else
					break;
		}

		if(verification)
			sistema(userCurrentLogin);
		else
			System.out.println("User not found or password incorrect!");

	}
	public void sistema(User userCurrent)
	{
		System.out.println("Welcome " + userCurrent.getName());
		int option;
		
		while(true)
		{
			System.out.printf("==========================================%n"
					+ "Select the option:%n");
			System.out.printf("[1] Allocate resource%n[2] Consult user%n[3] Consult resource%n[4] Logoff%n[5] General report%n");

			if(userCurrent instanceof Manager)
				System.out.printf("[6] View request%n");

			System.out.println("==========================================");


			option = input.nextInt();

			switch(option) {
				case 1:
					if(userCurrent.getRecursoAssociado() == null &&
					(userCurrent instanceof Researcher ||
							userCurrent instanceof Teacher ||userCurrent instanceof Manager))
						allocateResource(userCurrent);

					else
						System.out.println("User don't have permission");

					break;
				case 2:

					userConsult(userCurrent);

					break;
				case 3:
					resourceConsult();
					break;
				case 4:
					return;
				case 5:
					System.out.println(generalReport);
					break;
				case 6:
					if(userCurrent instanceof Manager){
						
						((Manager) userCurrent).viewRequest(requests,generalReport);
						
					}else
						System.out.println("Acess denied!");

					break;


				default:
					System.out.println("Invalid option!");
					break;
			}
		}




	}

	
	private void allocateResource(User userCurrent){

		System.out.println("Select the resource:");

		if(auditorium.getStatus() == Status.FREE)
			System.out.printf("[1] Auditorium%n");

		if(laboratory.getStatus() == Status.FREE)
			System.out.printf("[2] Laboratory%n");

		if(projector.getStatus() == Status.FREE)
			System.out.printf("[3] Projector%n");

		if(classroom.getStatus() == Status.FREE)
			System.out.printf("[4] Classroom%n");

		int optionAux = input.nextInt();


		switch(optionAux) {
			case 1:

				requests.add(new Request(auditorium,new Date(),
						new Hour(1),new Hour(2),new Activity(),userCurrent));

				auditorium.setStatus(Status.IN_ALLOCATION_PROCESS);

				generalReport.addResourceFree(-1);
				generalReport.addResourceInProcess(1);
				
				break;
			case 2:
				requests.add(new Request(laboratory,new Date(),
						new Hour(1),new Hour(2),new Activity(),userCurrent));

				laboratory.setStatus(Status.IN_ALLOCATION_PROCESS);

				generalReport.addResourceFree(-1);
				generalReport.addResourceInProcess(1);
				
				break;
			case 3:
				requests.add(new Request(projector,new Date(),
						new Hour(1),new Hour(2),new Activity(),userCurrent));

				projector.setStatus(Status.IN_ALLOCATION_PROCESS);

				generalReport.addResourceFree(-1);
				generalReport.addResourceInProcess(1);
				
				break;
			case 4:
				requests.add(new Request(classroom,new Date(),
						new Hour(1),new Hour(2),new Activity(),userCurrent));

				classroom.setStatus(Status.IN_ALLOCATION_PROCESS);

				generalReport.addResourceFree(-1);
				generalReport.addResourceInProcess(1);
				
				break;
			default:
				System.out.println("Invalid option");
				break;
		}

		System.out.println("Request made!");


	}

	private User newUser(int indentification){

		System.out.printf("Select the type of user:%n[1] Graduation student"
				+ "%n[2] Mastering student%n[3] Phd student%n[4] Teacher%n"
				+ "[5] Researcher%n[6] Manager");

		switch(input.nextInt()) {
			case 1:
				GraduationStudent user = new GraduationStudent(indentification);
				return user;
			case 2:
				MasteringStudent user1 = new MasteringStudent(indentification);
				return user1;
			case 3:
				PhdStudent user2 = new PhdStudent(indentification);
				return user2;

			case 4:
				Teacher user3 = new Teacher(indentification);
				return user3;
			case 5:
				Researcher user4 = new Researcher(indentification);
				return user4;
			case 6:
				Manager user5 = new Manager(indentification);
				return user5;
			default:
				System.out.println("Invalid option");
				break;
		}

		return null;

	}

	private void userConsult(User userCurrent){


		System.out.print("Enter user login:");
		String loginConsult = input.next();
		User userConsult = null;

		for(User userCurrentAux : usersRegistered)
			if(userCurrentAux.getLogin().equals(loginConsult)) {
				userConsult = userCurrentAux;
				break;
			}

		if(userConsult == null)
			System.out.println("User not found!");
		else {
			
			System.out.println(userConsult);
			
		}

	}
	private void resourceConsult(){
			
		System.out.printf("Select resource:%n[1] Auditorium [2] Laboratory"
				+ "[3] Projector [4] Classroom%n");
		int option = input.nextInt();
		
		switch(option) {
			case 1:
				System.out.println(auditorium);
				break;
			case 2:
				System.out.println(laboratory);
				break;
			case 3:
				System.out.println(projector);
				
				break;
			case 4:
				System.out.println(classroom);
				break;
			default:
				System.out.println("Option invalid");
				break;
		}
	}
}

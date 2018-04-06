package User;
import java.util.ArrayList;
import java.util.Scanner;

import others.DataHistoric;


public class User {

	private String name;
	private String login;
	private String password;
	private int identification;
	private String email;
	private String recursoAssociado = null;
	private ArrayList<DataHistoric> historic = new ArrayList<DataHistoric>();

	Scanner input = new Scanner(System.in);

	public User(int identification) {

		System.out.print("Name: ");
		this.name = input.nextLine();

		System.out.print("Login: ");
		this.login = input.next();

		System.out.print("Password: ");
		this.password = input.next();

		this.identification = identification;

		System.out.print("Your email: ");
		this.email = input.next();
	}

	
	public String getRecursoAssociado() {
		return recursoAssociado;
	}


	public void setRecursoAssociado(String recursoAssociado) {
		this.recursoAssociado = recursoAssociado;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdentification() {
		return identification;
	}
	public void setIdentification(int identification) {
		this.identification = identification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<DataHistoric> getHistoric() {
		return historic;
	}
	public void addHistoric(DataHistoric historic) {
		this.historic.add(historic);
	}


}

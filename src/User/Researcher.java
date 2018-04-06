package User;

public class Researcher extends User{

	public Researcher(int identification) {
		super(identification);

	}
	
	@Override
	public String toString() {
		return " RecursoAssociado: "
				+ getRecursoAssociado() + ", Name: " + getName()
				+ ", Login: " + getLogin() + ", Identification: "
				+ getIdentification() + ", Email: " + getEmail()
				+ ", Historic: " + getHistoric() 
				+ "]";
	}

}

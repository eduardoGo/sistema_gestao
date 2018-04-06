package User;

public class PhdStudent extends User {

	public PhdStudent(int identification) {
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

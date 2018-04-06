package User;

public class Teacher extends User{

	public Teacher(int identification) {
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

package User;

public class MasteringStudent extends User {

	public MasteringStudent(int identification) {
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

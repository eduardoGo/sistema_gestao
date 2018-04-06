package Recursos;

public class SalaAula extends Recurso{

	@Override
	public String toString() {
		return "Classroom [getStatus()=" + getStatus()
				+ ", getUserAssociated()=" + getUserAssociated()
				+ ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	public String getName(){
		return "Classroom";
	}
	

}

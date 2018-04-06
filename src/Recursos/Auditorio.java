package Recursos;

public class Auditorio extends Recurso{

	@Override
	public String toString() {
		return "Auditorium [getStatus()=" + getStatus()
				+ ", getUserAssociated()=" + getUserAssociated()
				+ ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	
	public String getName(){
		return "Auditorium";
	}



}

package Recursos;

public class Laboratorio extends Recurso{

	@Override
	public String toString() {
		return "Laboratory [getStatus()=" + getStatus()
				+ ", getUserAssociated()=" + getUserAssociated()
				+ ", getActivity()=" + getActivity() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

	public String getName(){
		return "Laboratory";
	}
	
}

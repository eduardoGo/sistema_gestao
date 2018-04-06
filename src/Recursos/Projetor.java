package Recursos;

public class Projetor extends Recurso {

	@Override
	public String toString() {
		return "Projector [getStatus()=" + getStatus()
				+ ", getUserAssociated()=" + getUserAssociated()
				+ ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public String getName() {
		
		return "Projector";
	}

	

}

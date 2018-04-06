package User;

import java.util.ArrayList;

import enums.Status;

import others.DataHistoric;
import others.GeneralReport;
import others.Request;

public class Manager extends User {

	public Manager(int identification) {
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
	
	public void viewRequest(ArrayList<Request> requests,GeneralReport generalReport){
		
		for(Request requestCurrent: requests) {
			System.out.printf("[%s] request by [%s] to [%s]%nRequest to %s - %d:%d until %d:%d%n[1] Accept [2] Reject",
					requestCurrent.getResource().getName(),requestCurrent.getUser().getName(),requestCurrent.getActivity().getTitle(),
					requestCurrent.getDate(),requestCurrent.getHourStart().getHour(),requestCurrent.getHourStart().getMinute(),
					requestCurrent.getHourEnd().getHour(),requestCurrent.getHourEnd().getMinute());
			int optionAux = input.nextInt();
			
			if(optionAux == 1) {
				
				requestCurrent.getResource().setStatus(Status.ALOCATED);
				requestCurrent.getResource().setData(requestCurrent.getDate());
				requestCurrent.getResource().setHourStart(requestCurrent.getHourStart());
				requestCurrent.getResource().setHourEnd(requestCurrent.getHourEnd());
				requestCurrent.getResource().setUserAssociated(requestCurrent.getUser().getName());
				requestCurrent.getResource().setActivity(requestCurrent.getActivity());
				requestCurrent.getUser().setRecursoAssociado(requestCurrent.getResource().getName());
				requestCurrent.getUser().addHistoric(new DataHistoric(requestCurrent.getResource().getName(),requestCurrent.getDate()));
				
				generalReport.addResourceAllocated(1);
				generalReport.addResourceInProcess(-1);
				generalReport.addAllocations(1);
			}else {
				requestCurrent.getResource().setStatus(Status.FREE);
				
				generalReport.addResourceInProcess(-1);
				generalReport.addResourceFree(1);
			}

		}
		requests.clear();
		System.out.println("No more requests");
	}

}

package Recursos;
import DateHour.Date;
import DateHour.Hour;
import enums.Status;
import others.Activity;

public abstract class Recurso {

	private Status status = Status.FREE;
	private String userAssociated = null;
	private Date data = null;
	private Hour hourStart = null;
	private Hour hourEnd = null;
	private Activity activity = null;

	
	public abstract String getName();
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getUserAssociated() {
		return userAssociated;
	}
	public void setUserAssociated(String userAssociated) {
		this.userAssociated = userAssociated;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Hour getHourStart() {
		return hourStart;
	}
	public void setHourStart(Hour hourStart) {
		this.hourStart = hourStart;
	}
	public Hour getHourEnd() {
		return hourEnd;
	}
	public void setHourEnd(Hour hourEnd) {
		this.hourEnd = hourEnd;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}



}

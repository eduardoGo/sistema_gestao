package others;

import Recursos.Recurso;
import User.User;
import DateHour.Hour;
import DateHour.Date;

public class Request {

	private Recurso resource;
	private Date date;
	private Hour hourStart;
	private Hour hourEnd;
	private Activity activity;
	private User user;




	public Request(Recurso resource, Date date, Hour hourStart, Hour hourEnd, Activity activity, User user) {

		this.resource = resource;
		this.date = date;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.activity = activity;
		this.user = user;
	}

	public Hour getHourStart() {
		return hourStart;
	}

	public Hour getHourEnd() {
		return hourEnd;
	}

	public User getUser() {
		return user;
	}
	
	public Date getDate() {
		return date;
	}

	public Activity getActivity() {
		return activity;
	}

	public Recurso getResource() {
		return resource;
	}
	

}

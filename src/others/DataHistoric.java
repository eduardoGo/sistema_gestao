package others;
import DateHour.Date;

public class DataHistoric {

	private String nameResource;
	private Date date;




	public DataHistoric(String nameResource, Date date) {

		this.nameResource = nameResource;
		this.date = date;
	}
	public String getNameResource() {
		return nameResource;
	}
	public void setNameResource(String nameResource) {
		this.nameResource = nameResource;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



}

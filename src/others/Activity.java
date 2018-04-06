package others;
import java.util.Scanner;

public class Activity {
	
	private String title;
	private String description;
	
	Scanner input = new Scanner(System.in);
	
	public Activity() {
		
		System.out.print("Activity title: ");
		this.title = input.nextLine();
		System.out.print("Activity description: ");
		this.description = input.nextLine();
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

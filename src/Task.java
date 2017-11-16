import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

class Task implements Serializable{
	private String description;
	private String title;
	private int priority;
	SimpleDateFormat format = new SimpleDateFormat ("yy:MM:dd:HH:mm");
	public Task(String title) {
		this.title = title;
	}
	public Task(String title,String description, int priority){
		this.title = title;
		this.description = description;
		this.priority=priority;
	}
	
	public String getDescription () {
		return description;
	}
	public void setDescription (String description) {
		this.description = description;
	}
	public String getTitle () {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getPriority() {
		return priority;
	}
	public String print(){
				return (title+": "+description+" - priority is "+priority);

		
	}
//	 add edit task, 2 and 5 are the same, and priority should be deleted after it has moved to finished
}
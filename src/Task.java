import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

class Task implements Serializable{
	private String description;
	private String title;
	private int priority;
	private Date date;
	private Date dateNow;
	long diff;
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
	SimpleDateFormat format = new SimpleDateFormat ("hh:mm");
	long finishTime;
	
	public Task(String title) {
		this.title = title;
	}
	public Task(String title,String description, int priority, Date date){
		this.title = title;
		this.description = description;
		this.priority=priority;
		this.date=date;
	}
	
	public String getDescription () {
		return description;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String print(){
		dateNow = new Date();
		diff = dateNow.getTime()-date.getTime();
		return (title+": "+description+" - priority is "+priority+" - Time is "+format.format(date)+" Time left: "+diffHours+" "+diffMinutes);
		
	}
}
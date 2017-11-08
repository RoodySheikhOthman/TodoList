import java.util.Date;

class Task {
	private String description;
	private String title;
	private Date date;
	private boolean finished;
	private int priority;
	
	public Task(String title) {
		this.title = title;
		finished = false;
	}
	public Task (String title,String description) {
		this.title = title;
		this.description = description;
		finished = false;
	}
	public Task(String title,String description, int priority){
		this.title = title;
		this.description = description;
		this.priority=priority;
		finished = false;
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
	public void setDate(Date date) {
		this.date = date;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String print(){
		return (title+": "+description+" - priority is "+priority);
		
	}
}
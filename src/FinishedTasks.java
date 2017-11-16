import java.util.ArrayList;


public class FinishedTasks {
	public ArrayList <Task> finiTasks;
	public FinishedTasks(){
		finiTasks = new ArrayList<Task>();
	}
	public void printFinished(){
		for(int i = 0; i<finiTasks.size();i++){
			System.out.println(i+1+"- "+ finiTasks.get(i).print());
		}
		}
	}


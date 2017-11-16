
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
class TodoList {
	private ArrayList <Task> tasks;
	private Task task;
	private FinishedTasks finishedTasks;
	SimpleDateFormat format = new SimpleDateFormat ("hh:mm");
	
	public TodoList(){
		tasks = new ArrayList<Task>();
		finishedTasks = new FinishedTasks();
	}

	public void mainToDo() throws IOException, ParseException {
		boolean b = true;
		System.out.println("What would you like to do? Type the number of the task you want.\n1- Add a new task.\n2- Show your Tasks.\n3- Delete a task.\n4- Save.\n5- Print saved tasks.\n6- Move a task to Finished.\n7- Show finished tasks.\n8- Exit");
		
		while (b) {
			try {	
				Scanner scanner1 = new Scanner(System.in);
				int n = Integer.parseInt(scanner1.nextLine());
				if (n>0&&n<9) {
					b = false;
					if(n==1){
						addTask();
					}
					else if(n==2){
						printTask();
					}
					else if(n==3){
						deleteTask();
					}
					else if(n==4){
						save();
					}
					else if (n==5){
						printFromSaved();
					}
					else if (n==6){
						moveToFinished();
					}
					else if (n==7){
						showFinished();
					}
					else if(n==8){
						
					}
				} else {
					System.out.println(n + " Isn't a valid option... please enter a number between 1 and 8");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter a number between 1 to 8 please...");	
			}
		}		
	}
	
	public void addTask () throws IOException, ParseException {
		
		System.out.println("Enter your new task title");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		task= new Task(s);
//		scannerTitle.close();
		System.out.println("Enter the description");
//		Scanner scannerDescription = new Scanner(System.in);
		String sDescription = scanner.nextLine();
		task.setDescription(sDescription);
//		scannerDescription.close();
		System.out.println("Enter the priority");
//		Scanner scannerPriority = new Scanner(System.in);
		int sPriority = Integer.parseInt(scanner.nextLine());	
		task.setPriority(sPriority);
		System.out.println("Enter the time in the format HH:MM");
		Date date = format.parse(scanner.nextLine());
		task.setDate(date);
//		scannerPriority.close();
		tasks.add(task);		
		System.out.println("You have added a new task successfully.");
		mainToDo();
	}
	public void deleteTask() throws IOException, ParseException{
		if(tasks.size()==0){
			System.out.println("There are no tasks to be deleted...");
			mainToDo();
		}
		else{
			System.out.println("Type the number of the task you want to delete");
			printTask2();
			Scanner scannerDelete = new Scanner(System.in);
			int number = Integer.parseInt(scannerDelete.nextLine());
			tasks.remove(number-1);
			System.out.println("The task is deleted");
			mainToDo();
		}
		
	}
	public void printTask() throws IOException, ParseException{
		for(int i = 0; i<tasks.size();i++){
			System.out.println(i+1+"- "+ tasks.get(i).print());
		}
		mainToDo();
	}
	public void printTask2(){
	for(int i = 0; i<tasks.size();i++){
		System.out.println(i+1+"- "+ tasks.get(i).print());
	}		
	}

	public void save() throws IOException, ParseException {
		try{
			FileOutputStream fileOut = new FileOutputStream("/afs/kth.se/home/tmp/1016/tmp-sda-1128/workspace/Roody/save.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(tasks);
			out.close();
			fileOut.close();
			System.out.println("Tasks are saved");
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		try{
			FileOutputStream fileOutFinished = new FileOutputStream("/afs/kth.se/home/tmp/1016/tmp-sda-1128/workspace/Roody/saveFinished.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOutFinished);
			out.writeObject(finishedTasks.finiTasks);
			out.close();
			fileOutFinished.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		mainToDo();
	}
	public void printFromSaved() throws IOException, ParseException{
		try{
			FileInputStream fileIn = new FileInputStream("/afs/kth.se/home/tmp/1016/tmp-sda-1128/workspace/Roody/save.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			tasks=(ArrayList<Task>)in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i){
			i.printStackTrace();
		}
		catch(ClassNotFoundException c){
			c.printStackTrace();
		}
		for(Task task:tasks){
			System.out.println( task.print());
		}
		try{
			FileInputStream fileIn = new FileInputStream("/afs/kth.se/home/tmp/1016/tmp-sda-1128/workspace/Roody/saveFinished.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			finishedTasks.finiTasks=(ArrayList<Task>)in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException i){
			i.printStackTrace();
		}
		catch(ClassNotFoundException c){
			c.printStackTrace();
		}
		mainToDo();
		
	}
	public void moveToFinished() throws IOException, ParseException{
		System.out.println("Type the number of the task you want to move to Finished tasks");
		printTask2();
		Scanner scannerDelete = new Scanner(System.in);
		int number = Integer.parseInt(scannerDelete.nextLine());
		finishedTasks.finiTasks.add(tasks.get(number-1));
		tasks.remove(number-1);
		System.out.println("The task is moved");
		mainToDo();
	}
	public void showFinished() throws IOException, ParseException{
		finishedTasks.printFinished();
		mainToDo();
	}
}



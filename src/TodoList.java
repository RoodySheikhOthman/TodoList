import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class TodoList {
	private ArrayList <Task> tasks;
	private Task task;
	
	public TodoList(){
		tasks = new ArrayList<Task>();
	}

	public void mainToDo() {
		boolean b = true;
		System.out.println("What would you like to do? Type the number of the task you want.\n1- Add a new task.\n2- Show your Tasks.\n3- Delete a task.\n4- Save and exit.\n");
		
		while (b) {
			try {	
				Scanner scanner1 = new Scanner(System.in);
				int n = Integer.parseInt(scanner1.nextLine());
				if (n>0&&n<5) {
					b = false;
					if(n==1){
						addTask ();
					}
					else if(n==2){
						printTask();
					}
					else if(n==3){
						deleteTask();
					}
					else if(n==4){
//						Needs completion
					}
				} else {
					System.out.println(n + " Isn't a valid option... please enter a number between 1 and 4");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter a number between 1 to 4 please...");	
			}
		}		
	}
	
	public void addTask () {
		
		System.out.println("Enter your new task title");
		Scanner scannerTitle = new Scanner(System.in);
		String s = scannerTitle.nextLine();
		task= new Task(s);
//		scannerTitle.close();
		System.out.println("Enter the description");
		Scanner scannerDescription = new Scanner(System.in);
		String sDescription = scannerDescription.nextLine();
		task.setDescription(sDescription);
//		scannerDescription.close();
		System.out.println("Enter the priority");
		Scanner scannerPriority = new Scanner(System.in);
		int sPriority = Integer.parseInt(scannerPriority.nextLine());	
		task.setPriority(sPriority);
//		scannerPriority.close();
		tasks.add(task);
		System.out.println("You have added a new task successfully.");
		mainToDo();
	}
	public void deleteTask(){
		System.out.println("Type the number of the task you want to delete");
		printTask2();
		Scanner scannerDelete = new Scanner(System.in);
		int number = Integer.parseInt(scannerDelete.nextLine());
		tasks.remove(number-1);
		System.out.println("The task is deleted");
		mainToDo();
	}
	public void printTask(){
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
	
	public void saveAndExit() throws FileNotFoundException{
		PrintWriter out = new PrintWriter("fileName.txt");
		out.println("There should be files written to a file here and fix them later");
	}

}

package ie.gmit.op;

import java.util.Scanner;

public class UserInterface {
	private int numberOfProcesses=0;
	private Scanner scanner;
	/**
	 * Constructor. Initialises the scanner.
	 */
	public UserInterface() {
		super();
		this.scanner =  new Scanner(System. in);
		
	}
	/**
	 * Reads in the number of processes
	 */
	public void readNumberOfprocesses(){
		//Run until there is a valid number
		do {
			System.out.println("Enter Number of processes:");
			//Check if there is valid int
		    while (!this.scanner.hasNextInt()) {
		        System.out.println("That's not a number! Try again.");
		        //Read whatever is there
		        this.scanner.next();
		    }
		    //Get the next in
		    this.numberOfProcesses = this.scanner.nextInt();
		} while (this.numberOfProcesses <= 0);
	}
	
	/**
	 * Reads in a number of preocess's name and burs time 
	 * @return Process[] processes
	 */
	public Process[] readProcesses(){
		Process[] processes= new Process[this.numberOfProcesses]; //The holder for the processes
		
		//Loop until we get all the processes
		for(int i=0; i<this.numberOfProcesses; i++){
			
			System.out.println("Enter name for process "+Integer.toString(i+1)+":");
			String name=this.scanner.next();
			

			
			//Read the burst time
			//Run until there is a valid number
			int bTime=-1;
			do {
				
				System.out.println("Enter burst time for process "+Integer.toString(i+1)+":");
				//Check if there is valid int
			    while (!this.scanner.hasNextInt()) {
			        System.out.println("That's not a number! Try again.");
			        //Read whatever is there
			        this.scanner.next();
			    }
			    //Get the next in
			    bTime = this.scanner.nextInt();
			} while (bTime <= 0);
			
			//Create a new process and add it to the list
			processes[i]=new Process(name, bTime);
		}
		
		
		//Return the processes
		return processes;
	}
	
	/**
	 * Reads in the algorithm type from the console
	 * @return int type
	 */
	public int readAlgorithm(){
		int answer=0;
		while(answer<1 || answer>4){
			System.out.println("Press 1 Round Robin");
			System.out.println("Press 2 FCFS");
			System.out.println("Press 3 SJF");
			System.out.println("Press 4 to exit");
			
			do {
				//Check if there is valid int
			    while (!this.scanner.hasNextInt()) {
			        System.out.println("That's not a number! Try again.");
			        //Read whatever is there
			        this.scanner.next();
			    }
			    //Get the next in
			    answer = this.scanner.nextInt();
			} while (answer <= 0);
		}
		
		return answer;
	}
	
	/**
	 * Reads in the quantum for the Round Robin
	 * @return int quantum
	 */
	public int readQuantum(){
		int quantum=0;
		do {
			System.out.println("Enter the quantum for Round Robin:");
			//Check if there is valid int
		    while (!this.scanner.hasNextInt()) {
		        System.out.println("That's not a number! Try again.");
		        //Read whatever is there
		        this.scanner.next();
		    }
		    //Get the next in
		    quantum = this.scanner.nextInt();
		} while (quantum <= 0);
		
		return quantum;
	}
	/**
	 * Prints out the first line of the details table
	 */
	public void printFirstLine(){
		System.out.format("%s%16s%20s%15s\n","Process name","Start time","Remaining time","Wait Time");
	}
	
	/**
	 * Writes out single formatted line filled with the details of a process
	 * @param arr
	 */
	public void printOneLine(CurrentStateContainer state){
		if(state!=null)
		System.out.format("\n%7s%16d%18d%18d\n",state.getProcessName(),state.getStartTime(),state.getRemainingTime(),state.getWaitTime());
	}
	
	/**
	 * Writes out the average waiting time.
	 * @param avg
	 */
	public void printAvarageWaitTime(float avg){
		System.out.println("Avarage Wait Time is:"+avg);
	} 
	
	
	
	
	
	
	
}




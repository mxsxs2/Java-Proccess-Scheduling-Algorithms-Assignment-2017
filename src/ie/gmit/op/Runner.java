package ie.gmit.op;


public class Runner {

	public static void main(String[] args) {
		//Create the user interface
		UserInterface UI= new UserInterface();
		//Get the number of processes from the user
		UI.readNumberOfprocesses();
		//Read the process details from the user
		Process[] processes = UI.readProcesses();
		//Get the algorithm
		int alg=UI.readAlgorithm();
		
		if(alg<4){
			//Create the calculator holder
			Calculator calc=null;
			//Decide the calculator algorithm
			switch(alg){
				case 1:
					//Get the quantum for rr
					int q=UI.readQuantum();
					//Create the rr calculator
					calc=new RRCalculator(q,processes);
					break;
				case 2:
					//Create the FCFS calculator
					calc=new FCFSCalculator(processes);
					break;
				case 3:
					//Create the SJF calculator
					calc=new SJFCalculator(processes);
					break;
			}
			
			UI.printFirstLine();
			
			//Loop until the calculation has next
			while(calc.hasNext()){
				UI.printOneLine(calc.getNext());
			}
			
			//Print avarage waiting time
			UI.printAvarageWaitTime(calc.getAverageWaitingTime());
		}
		
		
		
	}
}

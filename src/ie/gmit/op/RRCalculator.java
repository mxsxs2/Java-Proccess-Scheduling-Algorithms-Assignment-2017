package ie.gmit.op;

import java.util.stream.IntStream;

public class RRCalculator implements Calculator{
	private int quantum;
	private Process[] processes;
	private int[] remainings;
	private int[] waittime;
	private float[] quantums;
	private int currentWaitingTime;
	private int counter;
	private int counterMax;
	private int currentProcessIndex;
	/**
	 * Constructor which takes the process array and the quantum as an argument
	 * @param Processes[] processses
	 * @param int quantum
	 */
	public RRCalculator(int quantum, Process[] processes) {
		super();
		this.quantum = quantum;
		//Take a clone so the original data is not modified
		this.processes = Process.deepCloneArray(processes);
		
		//Call the initialization
		this.init();
	}
	/**
	 * Initializes the instance variables of the object
	 */
	private void init(){
		//Get the number of processes
		int noOfProcess=this.processes.length;
		//Initialize the remaining
		this.remainings=new int[noOfProcess];
		//Initialize wait time and quantum to 0
		this.waittime=new int[noOfProcess];
		this.quantums=new float[noOfProcess];
		
		//Set the remaining times
		for(int i=0; i<noOfProcess; i++){
			//Set the remaining time to the burst time
			this.remainings[i]=this.processes[i].getBurstTime();
		}
		//Preset the waiting time
		this.currentWaitingTime=0;
		//Set the current process index
		this.currentProcessIndex=0;
		//Calculate the max number of context change
		this.counterMax=this.getCountMaxValue();
	}

	/**
	 * Calculates the maximum number of context changes
	 * @return int max
	 */
	private int getCountMaxValue() {
		//The sum of the total burst times deviced by the quantum and rounded up
		return (int)Math.ceil((float)IntStream.of(this.remainings).sum()/(float)this.quantum);
	}
	
	/**
	 * Calculates the fraction of the quantum time, which is used at this run.
	 * @param int remainder
	 * @return float quantum - between 1 and 0
	 */
	private float calculateQuantumRun(int remainder){
		if(remainder>=this.quantum) return 1;
		return (float)remainder/(float)this.quantum;
	}

	@Override
	public float getAverageWaitingTime() {
		//The total of wait times divided by the amount of processes
		return (float)IntStream.of(this.waittime).sum()/(float)this.processes.length;
	}

	@Override
	public CurrentStateContainer getNext() {
		//the array to return
		CurrentStateContainer ret=null;
		
		//If it has next
		if(this.hasNext()) {
			//If next process didn't finish yet
			if(this.remainings[this.currentProcessIndex]>0){
				//Indicates if the qunatum is used up or not
				float quantumSegment=this.calculateQuantumRun(this.remainings[this.currentProcessIndex]);
				
				//Calculate the remaining time
				this.remainings[this.currentProcessIndex]= this.remainings[this.currentProcessIndex]-this.quantum>0 ? this.remainings[this.currentProcessIndex]-this.quantum : 0;
				
				//Recalculate the waiting time
				this.waittime[this.currentProcessIndex]=(int)(this.currentWaitingTime-this.quantums[this.currentProcessIndex]*this.quantum);			
				//Calculate the quantum run
				this.quantums[this.currentProcessIndex]+=quantumSegment;
				
				//Set the content of the current state calculator
				ret= new CurrentStateContainer();

				//Get the process name
				ret.setProcessName(this.processes[this.currentProcessIndex].getName());
				//Set the waiting time for the return
				ret.setStartTime(this.currentWaitingTime);
				//Set the remainder for the return
				ret.setRemainingTime(this.remainings[this.currentProcessIndex]);
				//Set the waiting time for the return
				ret.setWaitTime(this.waittime[this.currentProcessIndex]);
				
				//Add to the current waiting time the remaining or the full quantum
				this.currentWaitingTime+=this.quantum*quantumSegment;
				
				
			}
			//Set the current process index
			this.currentProcessIndex= this.currentProcessIndex+1<this.processes.length ? this.currentProcessIndex+1 : 0;
			//Increment the counter
			this.counter++;
		}
		return ret;
	}

	@Override
	public boolean hasNext() {
		//If the counter hasnt reached the counter max
		return this.counter<this.counterMax;
	}

	
}

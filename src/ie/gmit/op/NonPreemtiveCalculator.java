package ie.gmit.op;

public abstract class NonPreemtiveCalculator implements Calculator {
	private Process[] processes;
	private int counter=0;
	private int totalWaitTime=0;
	@Override
	public CurrentStateContainer getNext(){
		//the array to return
		CurrentStateContainer ret= null;
		//If there is a next one
		if(counter<this.processes.length){
			//Set the content of the current state calculator
			ret= new CurrentStateContainer();
			
			//Get the process name
			ret.setProcessName(this.processes[this.counter].getName());
			//Set the waiting time for the return
			ret.setStartTime(this.totalWaitTime);
			//Set the remainder for the return
			ret.setRemainingTime(0);
			//Set the waiting time for the return
			ret.setWaitTime(this.totalWaitTime);
			
			//Add the burst time of this process to the total wait time if it is not the last one
			if(counter+1<this.processes.length){
				this.totalWaitTime+=this.processes[this.counter].getBurstTime();
			}
			//Increase the counter for the next one
			this.counter++;
			//Return the int array
			return ret;
		}
		
		return null;
	}

	@Override
	public float getAverageWaitingTime() {
		return (float)this.totalWaitTime/(float)this.processes.length;
	}

	@Override
	public boolean hasNext() {
	  return this.counter<this.processes.length;
	}
	
	/**
	 * Returns the current process array
	 * @return Process[] processes
	 */
	protected Process[] getProcesses() {
		return processes;
	}
	/**
	 * Sets the process array
	 * @param Process[] processes
	 */
	protected void setProcesses(Process[] processes) {
		this.processes = processes;
	}
	

}

package ie.gmit.op;

public class Process implements Comparable<Process>, Cloneable{
	private String name;     //The name of the process	
	private int burstTime;	 //The burst time of the process
	
	/**
	 * Constructor which intializes the name and burst time
	 * @param String name
	 * @param int burstTime
	 */
	public Process(String name, int burstTime) {
		super();	
		this.name = name;
		this.burstTime = burstTime;
	}
	
	/**
	 *  Returns the name of the process
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set the name of the process
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the burst time of the process
	 * @return int burst time
	 */
	public int getBurstTime() {
		return burstTime;
	}
	/**
	 * Sets the burst time of the process
	 * @param burstTime
	 */
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	@Override
	public int compareTo(Process p2) {
		
		//If the burst time of the current one is smaller
		if(p2.getBurstTime() > this.getBurstTime()) return -1;
		
		//If the burst time of the current one is higher
		if(p2.getBurstTime() < this.getBurstTime()) return 1;
		
		//If the burst times are the same, they equals
		return 0;
	}
	@Override
	public Process clone() {
		//Return a new process with the same details
		return new Process(this.getName(),this.getBurstTime());
	}

	/**
	 * Returns a deep clone of a process array
	 * @param processes[] processes
	 * @return processes[] processes
	 */
	public static Process[] deepCloneArray(Process[] processes) {
		//Return a clone of the array
		return java.util.Arrays.stream(processes)
				               .map(p->p.clone())
				               .toArray(Process[]::new);
	}
	
}

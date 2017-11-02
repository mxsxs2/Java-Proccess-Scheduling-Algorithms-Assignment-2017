package ie.gmit.op;

public class CurrentStateContainer {
	//Name of the process
	private String processName;
	//The start time 
	private int startTime;
	//The remaining time left for the process
	private int remainingTime;
	//The total waiting time for this process
	private int waitTime;
	
	
	/**
	 * Null constructor for a current process state
	 */
	public CurrentStateContainer() {
		super();
	}

	/**
	 * Initialized constructor for a current process state
	 * @param String processName
	 * @param int startTime
	 * @param int remainingTime
	 * @param int waitTime
	 */
	public CurrentStateContainer(String processName, int startTime, int remainingTime, int waitTime) {
		super();
		this.processName = processName;
		this.startTime = startTime;
		this.remainingTime = remainingTime;
		this.waitTime = waitTime;
	}
	
	/**
	 * Returns the name of the proces
	 * @return String name
	 */
	public String getProcessName() {
		return processName;
	}
	/**
	 * Sets the name of the process
	 * @param String processName
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	/**
	 * Returns when the process started
	 * @return int start time
	 */
	public int getStartTime() {
		return startTime;
	}
	/**
	 * Sets the starting time of the process
	 * @param int startTime
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	/**
	 * Returns the remaining time left for the process 
	 * @return int remaining time
	 */
	public int getRemainingTime() {
		return remainingTime;
	}
	/**
	 * Sets he remaining time left for the process 
	 * @param int remainingTime
	 */
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	/**
	 * Returns the total waiting time of the process
	 * @return int wait time
	 */
	public int getWaitTime() {
		return waitTime;
	}
	/**
	 *  Set the total waiting time of the process
	 * @param int waitTime
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
}

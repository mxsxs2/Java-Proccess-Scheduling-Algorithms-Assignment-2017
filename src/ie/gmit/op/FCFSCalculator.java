package ie.gmit.op;

public class FCFSCalculator  extends NonPreemtiveCalculator implements Calculator{
	/**
	 * Constructor which takes the process array as an argument
	 * @param processes[] processes
	 */
	public FCFSCalculator(Process[] processes) {
		super();
		//Take a clone so the original data is not modified
		super.setProcesses(Process.deepCloneArray(processes));
	}

	
	
	
	
}

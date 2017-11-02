package ie.gmit.op;

public class SJFCalculator extends NonPreemtiveCalculator implements Calculator {
	
	/**
	 * Constructor which takes the process array as an argument
	 * @param processes[] processes
	 */
	public SJFCalculator(Process[] processes) {
		super();
		//Take a clone so the original data is not modified
		super.setProcesses(Process.deepCloneArray(processes));
		//Initialize the process array
		this.init();
	}
	
	/**
	 * Intiliazies the process array
	 */
	private void init() {
		//Convert the stream and sort the array
		super.setProcesses(java.util.Arrays.stream(super.getProcesses()).sorted((p1,p2)->p1.compareTo(p2)).toArray(Process[]::new));
	}
	
	
	

}

package ie.gmit.op;

public interface Calculator {
	
	/**
	 * Caluculates and returns the avarage waiting time of the given processes
	 * The processes has to be fully iterated through in order to get the final waiting time, otherwise it may return false values.
	 * @return float  avarage waiting time
	 */
	public float getAverageWaitingTime();
	/**
	 * Calculates the next process's state and returns it.
	 * @return CurrentStateContainer next state
	 */
	public CurrentStateContainer getNext();
	
	/**
	 * Returns wether the calculator has more processes to calculate or not
	 * @return boolean
	 */
	public boolean hasNext();
}

package WSP;

/**
 * The main Evaluation class for the WSP. It's pretty simple -- given an
 * Individual (ie, a chromosome) and a list of shifts and periods, calculate the
 * total number of staff required to fulfill the requirements. 
 *
 */

public class Plan {
	private Shift plan[];
	private Period periods[];
	private int sum = 0;

	/**
	 * Initialize Plan
	 * 
	 */
	public Plan(Individual individual, Shift shifts[], Period periods[]) {
		// Get individual's chromosome
		int chromosome[] = individual.getChromosome();
		
		this.plan = shifts;
		for (int geneIndex = 0; geneIndex < chromosome.length; geneIndex++) {
			this.plan[geneIndex].setNumStaff(chromosome[geneIndex]);
		}
		
		this.periods = periods;
	}
	
	public Plan(Plan clonable) {
		this.plan = clonable.getPlan();
		this.periods =  clonable.getPeriods();
	}
	
	public Shift[] getPlan() {
		return this.plan;
	}
	
	public Period[] getPeriods() {
		return this.periods;
	}

	/**
	 * Get total number of staff
	 * 
	 * @return number of staff
	 */
	public int getSumStaff() {
		if (this.sum > 0) {
			return this.sum;
		}

		// Loop over shifts in plan and calculate total number
		int totalSum = 0;
		for (int shiftIndex = 0; shiftIndex < this.plan.length; shiftIndex++) {
			totalSum += this.plan[shiftIndex].getStaffNumber();
		}

		return totalSum;
	}
	
	/**
	 * Calculate the number of conflicts with the requirements
	 * 
	 */
	
	public int calcClashes(Period periods[]) {
		int clashes = 0;
		int numStaff = 0;
		int tmp = 0;
		for (int shiftIndex=0; shiftIndex<24; shiftIndex++) {
			numStaff = 0;
			for (int i = 0; i < 4; i++) {
				tmp = shiftIndex+i;
				if (tmp >= 24) tmp -= 24;
				numStaff += this.plan[tmp].getStaffNumber();
			}
			
			for (int i = 6; i < 10; i++) {
				tmp = shiftIndex+i;
				if (tmp >= 24) tmp -= 24;
				numStaff += this.plan[tmp].getStaffNumber();
			}
			
			tmp = shiftIndex + 10;
			if (tmp > 24) tmp -= 24;
			
			for (int i = 0; i < 7; i++) {
				if (periods[i].getFromTime()<tmp && tmp <=periods[i].getToTime()) {
					if (numStaff<periods[i].getStaffNumber()) clashes++;
					break;
				}
			}
		}
		
		return clashes;
	}
}
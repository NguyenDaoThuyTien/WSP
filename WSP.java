package WSP;


/**
 * Main, executive class for the Workforce Scheduling Problem.
 *
 */
public class WSP {
	public static int maxGenerations = 10000;
	public static void main(String[] args) {
		
		
		int numShifts = 24;
		Shift shifts[] = new Shift[numShifts];
		Period periods[] = new Period[7];

		//Create shifts
		for (int shiftIndex=0; shiftIndex<numShifts; shiftIndex++) {
			shifts[shiftIndex] = new Shift(shiftIndex, shiftIndex);
			shifts[shiftIndex].setNumStaff(60);
		}
		
		//Create periods
		periods[0] = new Period(0, 0, 3, 20);
		periods[1] = new Period(1, 3, 6, 16);
		periods[2] = new Period(2, 6, 9, 25);
		periods[3] = new Period(3, 9, 12, 40);
		periods[4] = new Period(4, 12, 16, 60);
		periods[5] = new Period(5, 16, 20, 30);
		periods[6] = new Period(6, 20, 24, 25);
		
		// Initial GA
		GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.001, 0.9, 2, 5);

		// Initialize population
		Population population = ga.initPopulation(numShifts,shifts,periods);

		// Evaluate population
		ga.evalPopulation(population, shifts, periods);

		Plan startPlan = new Plan(population.getFittest(0), shifts, periods);
		System.out.println("Start staff: " + startPlan.getSumStaff());

		// Keep track of current generation
		int generation = 1;
		// Start evolution loop
		while (ga.isTerminationConditionMet(generation, maxGenerations) == false) {
			// Print fittest individual from population
			Plan plan = new Plan(population.getFittest(0), shifts, periods);
			System.out.println("G"+generation+" Minimum staff: " + plan.getSumStaff());

			// Apply crossover
			population = ga.crossoverPopulation(population);

			// Apply mutation
			population = ga.mutatePopulation(population,shifts);

			// Evaluate population
			ga.evalPopulation(population, shifts, periods);

			// Increment the current generation
			generation++;
		}
		
		System.out.println("Stopped after " + maxGenerations + " generations.");
		Plan plan = new Plan(population.getFittest(0), shifts, periods);
		System.out.println("Minimum staff: " + plan.getSumStaff());
		
		for (int shiftIndex=0; shiftIndex<numShifts; shiftIndex++) {
			System.out.print(shifts[shiftIndex].getStaffNumber()+" ");
		}
	}
}

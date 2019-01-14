package WSP;

import java.util.Random;

public class Individual {
	
	/**
	 * In this case, the chromosome is an array of integers rather than a string. 
	 */
	private int[] chromosome;
	private double fitness = -1;

	public Individual(Shift shifts[]) {
		int numShifts = 24;

		// 1 gene for room, 1 for time, 1 for professor
		int chromosomeLength = numShifts;
		// Create random individual
		int newChromosome[] = new int[chromosomeLength];
		int x;
		// Loop through groups
		int shiftIndex = 0;
		for (shiftIndex=0; shiftIndex<24; shiftIndex++) {
				Random ran = new Random();
				x = ran.nextInt(shifts[shiftIndex].getStaffNumber()+1) + 1;
				int numStaff = x;
				newChromosome[shiftIndex] = numStaff;
		}
		this.chromosome = newChromosome;
	}

	
    
	/**
	 * Initializes individual with specific chromosome
	 * 
	 * @param chromosome
	 *            The chromosome to give individual
	 */
	public Individual(int[] chromosome) {
		// Create individual chromosome
		this.chromosome = chromosome;
	}

	/**
	 * Gets individual's chromosome
	 * 
	 * @return The individual's chromosome
	 */
	public int[] getChromosome() {
		return this.chromosome;
	}

	/**
	 * Gets individual's chromosome length
	 * 
	 * @return The individual's chromosome length
	 */
	public int getChromosomeLength() {
		return this.chromosome.length;
	}

	/**
	 * Set gene at offset
	 * 
	 * @param gene
	 * @param offset
	 */
	public void setGene(int offset, int gene) {
		this.chromosome[offset] = gene;
	}

	/**
	 * Get gene at offset
	 * 
	 * @param offset
	 * @return gene
	 */
	public int getGene(int offset) {
		return this.chromosome[offset];
	}

	/**
	 * Store individual's fitness
	 * 
	 * @param fitness
	 *            The individuals fitness
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	/**
	 * Gets individual's fitness
	 * 
	 * @return The individual's fitness
	 */
	public double getFitness() {
		return this.fitness;
	}
	
	public String toString() {
		String output = "";
		for (int gene = 0; gene < this.chromosome.length; gene++) {
			output += this.chromosome[gene] + ",";
		}
		return output;
	}

	/**
	 * Search for a specific integer gene in this individual.
	 * 
	 * @param gene
	 * @return
	 */
	public boolean containsGene(int gene) {
		for (int i = 0; i < this.chromosome.length; i++) {
			if (this.chromosome[i] == gene) {
				return true;
			}
		}
		return false;
	}


	
}

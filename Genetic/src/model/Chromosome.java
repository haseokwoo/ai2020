package model;

import java.util.Random;

public class Chromosome {
	public static final int MAX_VALUE = 10;
	public static final double MUTATION_RATE = .1;
	public static final int NUMBER_OF_GENES = 10;
	private boolean[] genes = new boolean[NUMBER_OF_GENES];

	public boolean[] getGenes() {
		return genes;
	}

	public void setGenes(boolean[] genes) {
		this.genes = genes;
	}

	public double getValue() {
		double runningSum = 0;
		for (int n = 0; n < NUMBER_OF_GENES; ++n) {

			runningSum += Math.pow(2, n) * (genes[n] ? 1 : 0);
		}
		return runningSum * MAX_VALUE / (Math.pow(2, NUMBER_OF_GENES) - 1);
	}

	public void setValue(double pValue) {
		double runningSum = pValue * (Math.pow(2, NUMBER_OF_GENES) - 1) / MAX_VALUE;
		for (int n = NUMBER_OF_GENES - 1; n >= 0; --n) {
			if (runningSum >= Math.pow(2, n)) {
				genes[n] = true;
				runningSum -= Math.pow(2, n);
			} else {
				genes[n] = false;
			}
		}

		if (runningSum > 0.5) {
			genes[0] = true;
		}
	}

	public Chromosome mate(Chromosome c) {
		Chromosome returnValue = new Chromosome();
		// reproduction
		for (int n = 0; n < NUMBER_OF_GENES; ++n) {
			if (this.genes[n] == c.genes[n]) {
				returnValue.genes[n] = genes[n];
			} else {
				returnValue.genes[n] = new Random().nextBoolean();
			}
		}
		mutate(returnValue);
		return returnValue;
	}
	
	private void mutate(Chromosome c) {
		// mutation
		for (int n = 0; n < NUMBER_OF_GENES; ++n) {
			if (Math.random() < MUTATION_RATE) {
				c.genes[n] = !c.genes[n];
			}
		}
	}
	
	public void initializeWithRandomValues() {
		for (int n = 0; n < genes.length; ++n) {
			genes[n] = Math.random() > 0.5;
		}
	}
}

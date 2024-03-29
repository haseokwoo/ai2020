package ui;

import model.Chromosome;
import model.Population;

public class Main {
	public static final int POPULATION_SIZE = 100;
	public static final int NUMBER_OF_GENERATIONS = 100;

	public static void main(String[] args) {

		Population p = new Population(POPULATION_SIZE);
		for (int n = 0; n < NUMBER_OF_GENERATIONS; ++n) {
			p.spawnNextGeneration();
			System.out.println("Generation " + n + " + Best Fitness: " + p.getBestFitness());
		}
		System.out.println("The best fitness index is " + p.getBestFitness());
		System.out.println("This occurs at x = " + p.getBestFitnessInput1() + " and y = " + p.getBestFitnessInput2());
	}

}

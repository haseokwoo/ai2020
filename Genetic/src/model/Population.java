package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Population {
	List<Specimen> specimens = new ArrayList<>();
	private int populationSize;
	
	
	public Population (int populationSize) {
		this.populationSize = populationSize;
		setUpInitialPopulation();
	}
	
	private void setUpInitialPopulation() {
		for (int n=0; n<populationSize; ++n) {
			specimens.add(new Specimen());
		}
	}
	
	public double getBestFitness() {
		return specimens
				.stream()
				.max(Comparator.naturalOrder())
				.get()	//.orElse(new Specimen(5))	//get it! or else
				.getFitnessIndex();
	}
	
	public double getBestFitnessInput() {
		return specimens
				.stream()
				.max(Comparator.naturalOrder())
				.get()
				.getChromosomes()
				.get(0)
				.getValue();
	}
	
	public void spawnNextGeneration() {
		
	}
	
}

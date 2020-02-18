package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Population {
	List<Specimen> specimens = new ArrayList<>();
	private int populationSize;

	public Population(int populationSize) {
		this.populationSize = populationSize;
		setUpInitialPopulation();
	}

	private void setUpInitialPopulation() {
		for (int n = 0; n < populationSize; ++n) {
			specimens.add(new Specimen());
		}
	}

	public double getBestFitness() {
		return specimens.stream().max(Comparator.naturalOrder()).get() // .orElse(new Specimen(5)) //get it! or else
				.getFitnessIndex();
	}

	public double getBestFitnessInput() {
		return specimens.stream().max(Comparator.naturalOrder()).get().getChromosomes().get(0).getValue();
	}

	public void spawnNextGeneration() {
		List<Specimen> matingPool = new ArrayList<>();

		//add specimens to the mating pool based on fitness
		//to make it more likely to choose more fit specimens
		//at random
		for (double fred = 0; fred <= 1; fred += 0.1) {
			final double n = fred;
			matingPool.addAll(
					specimens
					.parallelStream()
					.filter(x -> x.getFitnessIndex() > n)
					.collect(Collectors.toList()));
		}
		
		specimens.clear();
		
		//choose specimens at random
		for(int n = 0; n < populationSize; ++n) {
			int specimenIndex1 = new Random().nextInt(matingPool.size());
			int specimenIndex2 = new Random().nextInt(matingPool.size());
			
			specimens.add(matingPool
					.get(specimenIndex1)
					.mate(matingPool.get(specimenIndex2)));
		}
//		//check errors
//		if(specimens.size() != populationSize) {
//			throw new IllegalStateException("Ahh!!!!!!!!!!!");
//		}
	}
}

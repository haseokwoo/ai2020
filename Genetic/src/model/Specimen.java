package model;

import java.util.ArrayList;
import java.util.List;

public class Specimen implements Comparable<Specimen> {
	List<Chromosome> chromosomes = new ArrayList<>();
	public static final int NUMBER_OF_CHROMOSOMES = 1;
	
	public Specimen() {
		for (int n = 0; n < NUMBER_OF_CHROMOSOMES; ++n) {
			chromosomes.add(new Chromosome());
			chromosomes.get(n).initializeWithRandomValues();
		}
	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public Specimen mate(Specimen s) {
		Specimen returnValue = new Specimen();
		for (int n = 0; n < NUMBER_OF_CHROMOSOMES; ++n) {
			returnValue.chromosomes.set(n, this.chromosomes.get(n).mate(s.chromosomes.get(n)));
		}
		return returnValue;
	}

	public double getFitnessIndex() {
		return (Math.sin(chromosomes.get(0).getValue()) + 1.0) / 2.0;
	}

	@Override
	public int compareTo(Specimen arg0) {
		if (this.getFitnessIndex() > arg0.getFitnessIndex()) {
			return 1;
		} else if (this.getFitnessIndex() < arg0.getFitnessIndex()) {
			return -1;
		} else {
			return 0;
		}
	}
}

package model;

import java.util.ArrayList;
import java.util.List;

public class Perceptron {
	private List<Boolean> input = new ArrayList<>();
	private List<Double> inputWeights = new ArrayList<>();
	private double threshold = 1;
	private double velocity = .2;
	
	public boolean isFiring() {
		int runningWeights = 0;
		for (int n=0; n < input.size(); ++n) {
			runningWeights += (input.get(n) ? 1 : 0) * inputWeights.get(n);
		}
		return runningWeights >= threshold;
	}
	
}

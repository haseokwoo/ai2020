package model;

import java.util.ArrayList;
import java.util.List;

public class Perceptron {
	public static final Double DEFAULT_WEIGHT = 0.1;
	private List<Boolean> input = new ArrayList<>();
	private List<Double> inputWeights = new ArrayList<>();
	private double threshold = 1;
	private double velocity = .2;
	
	public List<Boolean> getInput() {
		return input;
	}

	public List<Double> getInputWeights() {
		return inputWeights;
	}

	public double getThreshold() {
		return threshold;
	}

	public double getVelocity() {
		return velocity;
	}

	public boolean isFiring() {
		int runningWeights = 0;
		for (int n=0; n < input.size(); ++n) {
			runningWeights += (input.get(n) ? 1 : 0) * inputWeights.get(n);
		}
		return runningWeights >= threshold;
	}

	public void setInputWeights(List<Double> inputWeights) {
		this.inputWeights = inputWeights;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	public void addInput(boolean value) {
		input.add(value);
		inputWeights.add(DEFAULT_WEIGHT);
	}
	
	public void addInput(boolean value, double weight) {
		input.add(value);
		inputWeights.add(weight);
	}
	
	public void setInput(int index, boolean value) {
		input.set(index, value);
	}
	
	public void train() {
		for (int n =0; n<input.size(); ++n) {
			if(input.get(n)) {	//only strengthen connections that are firing
				inputWeights.set(n, inputWeights.get(n) * (1 + velocity));
			}
		}
	}
	
}

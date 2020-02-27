package ui;

import java.util.Arrays;

import model.Perceptron;

public class Main {
	public static void main(String[] args) {
		Perceptron p = new Perceptron();
		
		//logical and false,false...
		p.addInput(false);
		p.addInput(false);
		System.out.println(p.isFiring());
		
		//logical and false,true...
		p.setInput(0,false);
		p.setInput(1,true);
		System.out.println(p.isFiring());
		
		//logical and true,false...
		p.setInput(0,true);
		p.setInput(1,false);
		System.out.println(p.isFiring());
		
		//logical and true,false...
		p.setInput(0,true);
		p.setInput(1,true);
		System.out.println(p.isFiring());
	}
}

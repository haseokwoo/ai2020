package ui;

import java.util.Arrays;

import model.Perceptron;

public class Main {
	public static void main(String[] args) {
		Perceptron p = new Perceptron();
		p.addInput(false);
		p.addInput(false);
		p.addInput(false);

		boolean trained = false;
		do {
			trained = false;
			// logical or false,false,false...
			p.setInput(0, false);
			p.setInput(1, false);
			p.setInput(2, false);
			System.out.println("Logical or with false, false, false");
			System.out.println(p.isFiring());

			// logical or false,false,true...
			p.setInput(0, false);
			p.setInput(1, false);
			p.setInput(2, true);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with false,false, true");
			System.out.println(p.isFiring());

			// logical or false,true,false...
			p.setInput(0, false);
			p.setInput(1, true);
			p.setInput(2, false);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with false, true, false");
			System.out.println(p.isFiring());

			// logical or true,false,false...
			p.setInput(0, true);
			p.setInput(1, false);
			p.setInput(2, false);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with true, false, false");
			System.out.println(p.isFiring());

			// logical or false,true,true...
			p.setInput(0, false);
			p.setInput(1, true);
			p.setInput(2, true);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with false, true, true");
			System.out.println(p.isFiring());

			// logical or true,false,true...
			p.setInput(0, true);
			p.setInput(1, false);
			p.setInput(2, true);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with true, false, true");
			System.out.println(p.isFiring());

			// logical or true,true,false...
			p.setInput(0, true);
			p.setInput(1, true);
			p.setInput(2, false);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with true, true, false");
			System.out.println(p.isFiring());

			// logical or true,true,true...
			p.setInput(0, true);
			p.setInput(1, true);
			p.setInput(2, true);
			while (!p.isFiring()) {
				p.train();
				trained = true;
			}
			System.out.println("Logical or with true, true, true");
			System.out.println(p.isFiring());
		} while (trained);
	}
}

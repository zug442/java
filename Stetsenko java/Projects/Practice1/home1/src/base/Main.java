package base;

import base.printStar.PrintStars;

public class Main {
	public static void main (String [] args) {
		for (int i = 0; i < 3; i++) {
			PrintStars.printAll(args[i]);
		}
	}
}

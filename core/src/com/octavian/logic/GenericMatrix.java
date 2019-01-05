package com.octavian.logic;

public class GenericMatrix {

	int[][] matrix;

	Processor processor;

	public GenericMatrix(int n) {
		matrix = new int[n][n];
	}

	public int[] getNextRow() {
		return new int[3];
	}

	public int[] getNextCol() {
		return new int[3];
	}

}

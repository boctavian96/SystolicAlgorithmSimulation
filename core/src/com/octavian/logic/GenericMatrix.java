package com.octavian.logic;

public class GenericMatrix {

	int[][] matrix;

	Processor processor;

	public GenericMatrix(int n) {
		matrix = new int[n][n];
	}

	public GenericMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[] getNextRow() {
		return new int[3];
	}

	public int[] getNextCol() {
		return new int[3];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}

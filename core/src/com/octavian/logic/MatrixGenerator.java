package com.octavian.logic;

import java.util.Random;

public class MatrixGenerator {
	private MatrixGenerator() {

	}

	public static GenericMatrix generateMatrix() {
		final int MATRIX_SIZE = 3;
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		Random rand = new Random();

		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				matrix[i][j] = rand.nextInt(10);
			}
		}

		return new GenericMatrix(matrix);
	}
}

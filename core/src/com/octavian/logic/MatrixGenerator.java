package com.octavian.logic;

import java.util.Random;

public class MatrixGenerator {
	private static final int MATRIX_SIZE = 3;

	private MatrixGenerator() {

	}

	public static GenericMatrix generateMatrix() {
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		Random rand = new Random();

		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				matrix[i][j] = rand.nextInt(10);
			}
		}

		return new GenericMatrix(matrix);
	}

	public static GenericMatrix generateNegative() {
		final int POW_VALUE = -1;
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				matrix[i][j] = POW_VALUE;
			}
		}

		return new GenericMatrix(matrix);
	}
}

package com.octavian.util;

import java.util.ArrayList;
import java.util.List;

import com.octavian.logic.GenericMatrix;

public class HardMultiplication {

	public static final int[][] TEST_DATA_1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	public static final int[][] TEST_DATA_2 = new int[][] { { 4, 6, 9 }, { 3, 2, 1 }, { 5, 6, 1 } };

	private HardMultiplication() {
		// Nope.
	}

	/**
	 * Hard coded version. It's not used in the program. Only for debugging
	 * purposes.
	 *
	 * @return States.
	 */
	public static List<GenericMatrix> multiplicationHardcode(GenericMatrix a, GenericMatrix b) {
		List<GenericMatrix> state = new ArrayList<>();

		// 0
		state.add(new GenericMatrix());

		// 1
		state.add(
				new GenericMatrix(new int[][] { { a.matrix[0][0] * b.matrix[0][0], 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }));

		// 2
		state.add(
				new GenericMatrix(new int[][] {
						{ a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0],
								a.matrix[0][0] * b.matrix[0][1], 0 },
						{ a.matrix[1][0] * b.matrix[0][0], 0, 0 }, { 0, 0, 0 } }));

		// 3
		state.add(new GenericMatrix(new int[][] {
				{ a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0] + a.matrix[0][2] * b.matrix[2][0],
						a.matrix[0][0] * b.matrix[0][1] + a.matrix[0][1] * b.matrix[1][1],
						a.matrix[0][0] * b.matrix[0][2] },

				{ a.matrix[1][0] * b.matrix[0][0] + a.matrix[1][1] * b.matrix[1][0], a.matrix[1][0] * b.matrix[0][1],
						0 },
				{ a.matrix[2][0] * b.matrix[0][0], 0, 0 } }));

		// 4

		state.add(new GenericMatrix(new int[][] {
				{ a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0] + a.matrix[0][2] * b.matrix[2][0],
						a.matrix[0][0] * b.matrix[0][1] + a.matrix[0][1] * b.matrix[1][1]
								+ a.matrix[0][2] * b.matrix[2][1],
						a.matrix[0][0] * b.matrix[0][2] + a.matrix[0][1] * b.matrix[1][2] },

				{ a.matrix[1][0] * b.matrix[0][0] + a.matrix[1][1] * b.matrix[1][0] + a.matrix[1][2] * b.matrix[2][0],
						a.matrix[1][0] * b.matrix[0][1] + a.matrix[1][1] * b.matrix[1][1],
						a.matrix[1][0] * b.matrix[0][2] },
				{ a.matrix[2][0] * b.matrix[0][0] + a.matrix[2][1] * b.matrix[1][0], a.matrix[2][0] * b.matrix[0][1],
						0 } }));

		// 5
		state.add(new GenericMatrix(new int[][] { {
				a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0] + a.matrix[0][2] * b.matrix[2][0],
				a.matrix[0][0] * b.matrix[0][1] + a.matrix[0][1] * b.matrix[1][1] + a.matrix[0][2] * b.matrix[2][1],
				a.matrix[0][0] * b.matrix[0][2] + a.matrix[0][1] * b.matrix[1][2] + a.matrix[0][2] * b.matrix[2][2] },

				{ a.matrix[1][0] * b.matrix[0][0] + a.matrix[1][1] * b.matrix[1][0] + a.matrix[1][2] * b.matrix[2][0],
						a.matrix[1][0] * b.matrix[0][1] + a.matrix[1][1] * b.matrix[1][1]
								+ a.matrix[1][2] * b.matrix[2][1],
						a.matrix[1][0] * b.matrix[0][2] + a.matrix[1][1] * b.matrix[1][2] },
				{ a.matrix[2][0] * b.matrix[0][0] + a.matrix[2][1] * b.matrix[1][0] + a.matrix[2][2] * b.matrix[2][0],
						a.matrix[2][0] * b.matrix[0][1] + a.matrix[2][1] * b.matrix[1][1],
						a.matrix[2][0] * b.matrix[0][2] } }));

		// 6
		state.add(new GenericMatrix(new int[][] { {
				a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0] + a.matrix[0][2] * b.matrix[2][0],
				a.matrix[0][0] * b.matrix[0][1] + a.matrix[0][1] * b.matrix[1][1] + a.matrix[0][2] * b.matrix[2][1],
				a.matrix[0][0] * b.matrix[0][2] + a.matrix[0][1] * b.matrix[1][2] + a.matrix[0][2] * b.matrix[2][2] },

				{ a.matrix[1][0] * b.matrix[0][0] + a.matrix[1][1] * b.matrix[1][0] + a.matrix[1][2] * b.matrix[2][0],
						a.matrix[1][0] * b.matrix[0][1] + a.matrix[1][1] * b.matrix[1][1]
								+ a.matrix[1][2] * b.matrix[2][1],
						a.matrix[1][0] * b.matrix[0][2] + a.matrix[1][1] * b.matrix[1][2]
								+ a.matrix[1][2] * b.matrix[2][2] },
				{ a.matrix[2][0] * b.matrix[0][0] + a.matrix[2][1] * b.matrix[1][0] + a.matrix[2][2] * b.matrix[2][0],
						a.matrix[2][0] * b.matrix[0][1] + a.matrix[2][1] * b.matrix[1][1]
								+ a.matrix[2][2] * b.matrix[2][1],
						a.matrix[2][0] * b.matrix[0][2] + a.matrix[2][1] * b.matrix[1][2] } }));

		// 7

		state.add(new GenericMatrix(new int[][] { {
				a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0] + a.matrix[0][2] * b.matrix[2][0],
				a.matrix[0][0] * b.matrix[0][1] + a.matrix[0][1] * b.matrix[1][1] + a.matrix[0][2] * b.matrix[2][1],
				a.matrix[0][0] * b.matrix[0][2] + a.matrix[0][1] * b.matrix[1][2] + a.matrix[0][2] * b.matrix[2][2] },

				{ a.matrix[1][0] * b.matrix[0][0] + a.matrix[1][1] * b.matrix[1][0] + a.matrix[1][2] * b.matrix[2][0],
						a.matrix[1][0] * b.matrix[0][1] + a.matrix[1][1] * b.matrix[1][1]
								+ a.matrix[1][2] * b.matrix[2][1],
						a.matrix[1][0] * b.matrix[0][2] + a.matrix[1][1] * b.matrix[1][2]
								+ a.matrix[1][2] * b.matrix[2][2] },
				{ a.matrix[2][0] * b.matrix[0][0] + a.matrix[2][1] * b.matrix[1][0] + a.matrix[2][2] * b.matrix[2][0],
						a.matrix[2][0] * b.matrix[0][1] + a.matrix[2][1] * b.matrix[1][1]
								+ a.matrix[2][2] * b.matrix[2][1],
						a.matrix[2][0] * b.matrix[0][2] + a.matrix[2][1] * b.matrix[1][2]
								+ a.matrix[2][2] * b.matrix[2][2] } }));

		return state;
	}
}

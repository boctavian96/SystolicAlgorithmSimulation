package com.octavian.logic;

import java.util.ArrayList;
import java.util.List;

import com.octavian.logic.meta.Column;
import com.octavian.logic.meta.Row;

public class SystolicMatrixMultiplication {

	public GenericMatrix a;
	public GenericMatrix b;
	GenericMatrix result;

	int[][] dummy1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	int[][] dummy2 = new int[][] { { 4, 6, 9 }, { 3, 2, 1 }, { 5, 6, 1 } };

	public SystolicMatrixMultiplication() {
		// a = MatrixGenerator.generateMatrix();
		// b = MatrixGenerator.generateMatrix();

		a = new GenericMatrix(dummy1);
		b = new GenericMatrix(dummy2);
		result = new GenericMatrix();
	}

	/**
	 * Hardcoded version. It's not used in the program. Only for debugging purposes.
	 *
	 * @return States.
	 */
	public List<GenericMatrix> multiplicationHardcode() {
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

	private List<Row> cutLastRow(List<Row> rows) {
		List<Row> rowsWithoutLastElement = new ArrayList<>(rows);

		for (Row row : rowsWithoutLastElement) {
			row.getValues().remove(row.getValues().size() - 1);
		}

		return rowsWithoutLastElement;
	}

	private List<Column> cutLastCol(List<Column> cols) {
		List<Column> colsWithoutLastElement = new ArrayList<>(cols);

		for (Column col : colsWithoutLastElement) {
			col.getValues().remove(col.getValues().size() - 1);
		}

		return colsWithoutLastElement;
	}

	public List<GenericMatrix> archMultiplication() {
		ProcessorArchitecture processorsArchitecture = new ProcessorArchitecture();
		List<GenericMatrix> state = new ArrayList<>();

		// Tick 0, no values.
		state.add(new GenericMatrix());

		List<Row> rows = a.toRows();
		List<Column> cols = b.toCols();

		for (int i = 0; i < 5; i++) {
			processorsArchitecture.pushRow(rows);
			processorsArchitecture.pushCol(cols);
			processorsArchitecture.process();

			state.add(processorsArchitecture.archToMatrix());

			rows = cutLastRow(rows);
			cols = cutLastCol(cols);
		}

		// Pushing extra 2 ticks with null elements.

		processorsArchitecture.pushNull();
		processorsArchitecture.process();
		state.add(processorsArchitecture.archToMatrix());

		processorsArchitecture.pushNull();
		processorsArchitecture.process();
		state.add(processorsArchitecture.archToMatrix());

		return state;

	}
}

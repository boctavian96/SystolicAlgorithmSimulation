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

	public List<GenericMatrix> multiplication() {
		List<GenericMatrix> our = new ArrayList<>();

		// 0
		our.add(new GenericMatrix());

		// 1
		our.add(new GenericMatrix(new int[][] { { a.matrix[0][0] * b.matrix[0][0], 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }));

		// 2
		our.add(new GenericMatrix(
				new int[][] {
						{ a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0],
								a.matrix[0][0] * b.matrix[0][1], 0 },
						{ a.matrix[1][0] * b.matrix[0][0], 0, 0 }, { 0, 0, 0 } }));

		// 3
		our.add(new GenericMatrix(new int[][] {
				{ a.matrix[0][0] * b.matrix[0][0] + a.matrix[0][1] * b.matrix[1][0] + a.matrix[0][2] * b.matrix[2][0],
						a.matrix[0][0] * b.matrix[0][1] + a.matrix[0][1] * b.matrix[1][1],
						a.matrix[0][0] * b.matrix[0][2] },

				{ a.matrix[1][0] * b.matrix[0][0] + a.matrix[1][1] * b.matrix[1][0], a.matrix[1][0] * b.matrix[0][1],
						0 },
				{ a.matrix[2][0] * b.matrix[0][0], 0, 0 } }));

		// 4

		our.add(new GenericMatrix(new int[][] {
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
		our.add(new GenericMatrix(new int[][] { {
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
		our.add(new GenericMatrix(new int[][] { {
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

		our.add(new GenericMatrix(new int[][] { {
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

		return our;
	}

	private List<Row> cutLastRow(List<Row> rows) {
		List<Row> newRows = new ArrayList<>(rows);

		for (Row row : newRows) {
			row.getValues().remove(row.getValues().size() - 1);
		}

		return newRows;
	}

	private List<Column> cutLastCol(List<Column> cols) {
		List<Column> newcols = new ArrayList<>(cols);

		for (Column col : newcols) {
			col.getValues().remove(col.getValues().size() - 1);
		}

		return newcols;
	}

	public List<GenericMatrix> archMultiplication() {
		ProcessorArchitecture arch = new ProcessorArchitecture();
		List<GenericMatrix> our = new ArrayList<>();

		List<Row> rows = a.toRows();
		List<Column> cols = b.toCols();

		for (int i = 0; i < 5; i++) {
			// arch.sendVars();
			arch.pushRow(rows);
			arch.pushCol(cols);
			arch.process();

			our.add(arch.archToMatrix());

			rows = cutLastRow(rows);
			cols = cutLastCol(cols);
		}

		arch.pushNull();
		arch.process();
		our.add(arch.archToMatrix());

		arch.pushNull();
		arch.process();
		our.add(arch.archToMatrix());

		return our;

	}
}

package com.octavian.logic;

import java.util.ArrayList;
import java.util.List;

import com.octavian.logic.meta.Column;
import com.octavian.logic.meta.Row;

public class SystolicMatrixMultiplication {

	public GenericMatrix a;
	public GenericMatrix b;

	public SystolicMatrixMultiplication() {
		a = MatrixGenerator.generateMatrix();
		b = MatrixGenerator.generateMatrix();

	}

	public SystolicMatrixMultiplication(int[][] data1, int[][] data2) {
		a = new GenericMatrix(data1);
		b = new GenericMatrix(data2);
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

	public List<GenericMatrix> multiplication() {
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

			state.add(processorsArchitecture.architectureToMatrix());

			rows = cutLastRow(rows);
			cols = cutLastCol(cols);
		}

		// Pushing extra 2 ticks with null elements.
		processorsArchitecture.pushNull();
		processorsArchitecture.process();
		state.add(processorsArchitecture.architectureToMatrix());

		processorsArchitecture.pushNull();
		processorsArchitecture.process();
		state.add(processorsArchitecture.architectureToMatrix());

		return state;

	}
}

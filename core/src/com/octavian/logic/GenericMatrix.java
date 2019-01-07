package com.octavian.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.octavian.logic.meta.Column;
import com.octavian.logic.meta.Row;

public class GenericMatrix {

	public int[][] matrix;

	public GenericMatrix() {
		matrix = new int[3][3];
	}

	public GenericMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void push(Row row, Column col, int colNumber) {
		matrix[0][colNumber] += row.getLastValue() * col.getLastValue();
		matrix[1][colNumber] += row.getLastValue() * col.getLastValue();
		matrix[2][colNumber] += row.getLastValue() * col.getLastValue();
	}

	public List<Column> toCols() {
		List<Column> cols = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			List<Integer> values = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				values.add(matrix[j][i]);
			}
			cols.add(new Column(values, i));
		}

		return cols;
	}

	public List<Row> toRows() {
		List<Row> rows = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			List<Integer> values = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				values.add(matrix[i][j]);
			}
			rows.add(new Row(values, i));
		}

		return rows;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericMatrix other = (GenericMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

}

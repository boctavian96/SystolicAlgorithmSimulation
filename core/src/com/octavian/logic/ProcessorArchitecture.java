package com.octavian.logic;

import java.util.ArrayList;
import java.util.List;

import com.octavian.logic.meta.Column;
import com.octavian.logic.meta.Row;

public class ProcessorArchitecture {

	private List<Processor> processors;

	public ProcessorArchitecture() {
		super();

		processors = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			processors.add(new Processor());
		}

		// Setting the references to neighbors.
		processors.get(0).setDown(processors.get(3));
		processors.get(0).setRight(processors.get(1));

		processors.get(1).setDown(processors.get(4));
		processors.get(1).setRight(processors.get(2));

		processors.get(2).setDown(processors.get(5));
		processors.get(2).setRight(null);

		processors.get(3).setDown(processors.get(6));
		processors.get(3).setRight(processors.get(4));

		processors.get(4).setDown(processors.get(7));
		processors.get(4).setRight(processors.get(5));

		processors.get(5).setDown(processors.get(8));
		processors.get(5).setRight(null);

		processors.get(6).setDown(null);
		processors.get(6).setRight(processors.get(7));

		processors.get(7).setDown(null);
		processors.get(7).setRight(processors.get(8));

		processors.get(8).setDown(null);
		processors.get(8).setRight(null);
	}

	public void pushRow(List<Row> row) {
		// 0, 3, 6
		// We push the rows only from left.
		processors.get(0).setLeft(row.get(0).getLastValue());
		processors.get(3).setLeft(row.get(1).getLastValue());
		processors.get(6).setLeft(row.get(2).getLastValue());

	}

	public void pushCol(List<Column> col) {
		// 0, 1, 2
		// We push the cols only from up.
		processors.get(0).setUpper(col.get(0).getLastValue());
		processors.get(1).setUpper(col.get(1).getLastValue());
		processors.get(2).setUpper(col.get(2).getLastValue());
	}

	public void pushNull() {
		processors.get(0).setLeft(null);
		processors.get(3).setLeft(null);
		processors.get(6).setLeft(null);

		processors.get(0).setUpper(null);
		processors.get(1).setUpper(null);
		processors.get(2).setUpper(null);
	}

	public void process() {
		for (Processor p : processors) {
			p.process();
		}

	}

	public GenericMatrix architectureToMatrix() {
		int[][] matrix = new int[3][3];
		int processorIndex = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = processors.get(processorIndex).getNumber();
				processorIndex++;
			}
		}

		return new GenericMatrix(matrix);
	}

	public List<Processor> getProcessors() {
		return processors;
	}

	public void setProcessors(List<Processor> processors) {
		this.processors = processors;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Processor p : processors) {
			sb.append(p + " \n");
		}

		return sb.toString();
	}

}

package com.octavian.logic.meta;

import java.util.List;

public class Row {
	private static final Integer DUMMY_VALUE = 0;

	private List<Integer> values;
	private int rowNumber;

	public Row(List<Integer> values, int delay) {
		this.values = values;
		this.rowNumber = delay;
		for (int i = 0; i < delay; i++) {
			this.values.add(DUMMY_VALUE);
		}

		if (delay == 1) {
			this.values.add(0, DUMMY_VALUE);
		}

		if (delay == 0) {
			this.values.add(0, DUMMY_VALUE);
			this.values.add(0, DUMMY_VALUE);

		}
	}

	public List<Integer> getValues() {
		return values;
	}

	public Integer getValue(int index) {
		return values.get(index);
	}

	public Integer getLastValue() {
		return values.get(values.size() - 1);

	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" [ ");

		for (int value : values) {
			sb.append(value);
			sb.append(" ");
		}
		sb.append("]");

		return sb.toString();
	}

}

package com.octavian.logic;

public class Processor {
	private float number;

	public Processor(float number) {
		this.number = number;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
	}

	public float process() {
		return 1 / number;
	}

}

package com.octavian.logic;

import java.util.List;

public class Processor {
	private Integer number;

	private Integer upper;
	private Integer left;

	// ID Processor
	private Processor rightProcessor;
	private Processor downProcessor;

	public Processor() {
		this.number = 0;
		this.rightProcessor = null;
		this.downProcessor = null;
	}

	public Processor(Processor right, Processor down) {
		this.number = 0;
		this.rightProcessor = right;
		this.downProcessor = down;
	}

	public boolean isValid() {
		return upper != null && left != null;
	}

	public List<Processor> process(List<Processor> processors) {

		if (isValid()) {
			number += upper * left;
		}

		return processors;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {

		if (downProcessor != null)
			downProcessor.setUpper(this.upper);

		this.upper = upper;
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {

		if (rightProcessor != null)
			rightProcessor.setLeft(this.left);

		this.left = left;
	}

	public Integer getNumber() {
		return number;
	}

	public void setRight(Processor right) {
		this.rightProcessor = right;
	}

	public void setDown(Processor down) {
		this.downProcessor = down;
	}

	@Override
	public String toString() {
		return "Upper: " + upper + " Left: " + left + " Number: " + number;
	}

}

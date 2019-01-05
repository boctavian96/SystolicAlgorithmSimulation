package com.octavian.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class ProcessorUI {
	private String value;
	private Rectangle proccesorRect;

	public ProcessorUI(String value, float processorSize, float x, float y) {
		this.value = value;
		this.proccesorRect = new Rectangle(x, y, processorSize, processorSize);
	}

	public void drawProcessor(ShapeRenderer shape) {
		shape.rect(proccesorRect.x, proccesorRect.y, proccesorRect.getHeight(), proccesorRect.getWidth());
	}

	public String getValue() {
		return value;
	}

	public float getX() {
		return proccesorRect.getX();
	}

	public float getY() {
		return proccesorRect.getY();
	}
}

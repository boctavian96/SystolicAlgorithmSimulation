package com.octavian.util;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Utils {

	private Utils() {
		// Nope.
	}

	public static void drawDebugRectangle(ShapeRenderer shape, Rectangle rectangle) {
		shape.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}
}

package com.octavian.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by octavian on 12/25/18.
 */

public final class FontFactory {
	public static final String FONT_COOLVETICA = "coolvetica rg.ttf";

	private static FontFactory instance;

	private BitmapFont font;

	private FontFactory() {
		super();
	}

	public static synchronized FontFactory getInstance() {
		if (instance == null) {
			instance = new FontFactory();
		}
		return instance;
	}

	public BitmapFont generateFont(String fontName, int size, Color color) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontName));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = size;
		parameter.color = color;

		font = generator.generateFont(parameter);
		generator.dispose();

		return font;
	}

	public void dispose() {
		font.dispose();
	}
}
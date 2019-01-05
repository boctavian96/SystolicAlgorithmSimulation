package com.octavian.project;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.octavian.config.Config;
import com.octavian.ui.FontFactory;

public abstract class AbstractScreen extends ScreenAdapter {

	protected Vector3 touchPoint;
	protected OrthographicCamera camera;
	protected FitViewport viewport;
	protected SpriteBatch gameBatch;

	protected BitmapFont font16;
	protected BitmapFont font16Red;
	protected BitmapFont font16Black;
	protected BitmapFont font16Blue;

	protected BitmapFont font32;
	protected BitmapFont font32Red;
	protected BitmapFont font32Black;

	protected BitmapFont font64;
	protected BitmapFont font64Red;
	protected BitmapFont font64Black;

	public AbstractScreen() {
		camera = new OrthographicCamera(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		viewport = new FitViewport(Config.WORLD_WIDTH, Config.WORLD_HEIGHT, camera);

		font16 = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 16, Color.WHITE);
		font16Red = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 16, Color.RED);
		font16Black = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 16, Color.BLACK);
		font16Blue = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 16, Color.BLUE);

		font32 = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 32, Color.WHITE);
		font32Red = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 32, Color.RED);
		font32Black = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 32, Color.BLACK);

		font64 = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 64, Color.WHITE);
		font64Red = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 64, Color.RED);
		font64Black = FontFactory.getInstance().generateFont(FontFactory.FONT_COOLVETICA, 64, Color.BLACK);

		touchPoint = new Vector3();
	}
}

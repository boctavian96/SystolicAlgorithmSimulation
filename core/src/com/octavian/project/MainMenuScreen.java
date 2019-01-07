package com.octavian.project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.octavian.config.Config;
import com.octavian.util.Utils;

public class MainMenuScreen extends AbstractScreen {

	private Systolic main;

	private Rectangle startBounds;
	private Rectangle aboutBounds;
	private Rectangle exitBounds;

	// For Debug
	private ShapeRenderer shapeDebugRenderer;

	public MainMenuScreen(Systolic main) {
		super();
		this.main = main;

		startBounds = new Rectangle(Config.WORLD_WIDTH / 2 - 2 * Config.WORLD_UNIT,
				Config.WORLD_HEIGHT - 9 * Config.WORLD_UNIT, 4 * Config.WORLD_UNIT, Config.WORLD_UNIT);
		aboutBounds = new Rectangle(Config.WORLD_WIDTH / 2 - 2 * Config.WORLD_UNIT,
				Config.WORLD_HEIGHT - 11 * Config.WORLD_UNIT, 4 * Config.WORLD_UNIT, Config.WORLD_UNIT);
		exitBounds = new Rectangle(Config.WORLD_WIDTH / 2 - 2 * Config.WORLD_UNIT,
				Config.WORLD_HEIGHT - 13 * Config.WORLD_UNIT, 4 * Config.WORLD_UNIT, Config.WORLD_UNIT);

		shapeDebugRenderer = new ShapeRenderer();

	}

	public void update() {
		camera.update();

		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			Gdx.app.log("INFO", "Click ! " + "X = " + Gdx.input.getX() + " Y = " + Gdx.input.getY());
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (startBounds.contains(touchPoint.x, touchPoint.y)) {
				main.setScreen(new DataScreen(main));
				Gdx.app.log("INFO", "Am intrat pe screen-ul de data");
			}

			if (aboutBounds.contains(touchPoint.x, touchPoint.y)) {
				main.setScreen(new AboutScreen(main));
				Gdx.app.log("INFO", "Am intrat pe screen-ul de about");
			}

			if (exitBounds.contains(touchPoint.x, touchPoint.y)) {
				Gdx.app.log("INFO", "Quitting the app");
				Gdx.app.exit();
			}

		}
	}

	/**
	 * Used only for debug purpouses.
	 */
	@SuppressWarnings("unused")
	private void drawDebug() {
		shapeDebugRenderer.setProjectionMatrix(camera.combined);
		shapeDebugRenderer.begin(ShapeRenderer.ShapeType.Line);
		Utils.drawDebugRectangle(shapeDebugRenderer, startBounds);
		Utils.drawDebugRectangle(shapeDebugRenderer, aboutBounds);
		Utils.drawDebugRectangle(shapeDebugRenderer, exitBounds);
		shapeDebugRenderer.end();
	}

	public void draw() {
		gameBatch = main.getBatch();
		GL20 gl = Gdx.gl;
		gl.glClearColor(0f, 0f, 0f, 1f);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		gameBatch.setProjectionMatrix(camera.combined);

		gameBatch.enableBlending();
		gameBatch.begin();
		font64.draw(gameBatch, "Systolic Algorithms Project", Config.WORLD_WIDTH / 4,
				Config.WORLD_HEIGHT - 2 * Config.WORLD_UNIT);

		float buttonX = Config.WORLD_WIDTH / 2 - 2 * Config.WORLD_UNIT;
		float buttonY = Config.WORLD_HEIGHT - 8 * Config.WORLD_UNIT;

		font32.draw(gameBatch, "Begin", buttonX, buttonY);
		font32.draw(gameBatch, "About", buttonX, buttonY - 2 * Config.WORLD_UNIT);
		font32.draw(gameBatch, "Exit", buttonX, buttonY - 4 * Config.WORLD_UNIT);

		gameBatch.end();
	}

	@Override
	public void render(float delta) {
		update();
		draw();
		// drawDebug();
	}

}

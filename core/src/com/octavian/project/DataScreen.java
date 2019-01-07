package com.octavian.project;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.octavian.config.Config;
import com.octavian.logic.GenericMatrix;
import com.octavian.logic.SystolicMatrixMultiplication;
import com.octavian.ui.ProcessorUI;

public class DataScreen extends AbstractScreen {

	private static final float PROCESSOR_SIZE = 64f;

	Systolic main;

	ShapeRenderer shapeRenderer;
	List<ProcessorUI> processors;
	SystolicMatrixMultiplication op;
	List<GenericMatrix> matrixes;

	Texture arrowLeft;
	Texture arrowUp;

	int tick;

	public DataScreen(Systolic main) {
		super();
		this.main = main;
		shapeRenderer = new ShapeRenderer();
		processors = new ArrayList<>();
		op = new SystolicMatrixMultiplication();
		matrixes = op.archMultiplication();
		arrowLeft = new Texture(Gdx.files.internal("lgdxRect.png"));
		arrowUp = new Texture(Gdx.files.internal("lgdxRectUp.png"));

		tick = 0;

		// Row 1
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 6 * Config.WORLD_UNIT, 18 * Config.WORLD_UNIT));
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 12 * Config.WORLD_UNIT, 18 * Config.WORLD_UNIT));
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 18 * Config.WORLD_UNIT, 18 * Config.WORLD_UNIT));

		// Row 2
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 6 * Config.WORLD_UNIT, 12 * Config.WORLD_UNIT));
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 12 * Config.WORLD_UNIT, 12 * Config.WORLD_UNIT));
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 18 * Config.WORLD_UNIT, 12 * Config.WORLD_UNIT));

		// Row 3
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 6 * Config.WORLD_UNIT, 6 * Config.WORLD_UNIT));
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 12 * Config.WORLD_UNIT, 6 * Config.WORLD_UNIT));
		processors.add(new ProcessorUI("0", PROCESSOR_SIZE, 18 * Config.WORLD_UNIT, 6 * Config.WORLD_UNIT));
	}

	public void update() {
		camera.update();

		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			main.setScreen(new MainMenuScreen(main));
			Gdx.app.log("INFO", "Back to main");
		}

		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			if (tick < matrixes.size() - 1) {
				tick++;
			}

			GenericMatrix aux = matrixes.get(tick);
			int index = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					processors.get(index).setValue("" + aux.matrix[i][j]);
					index++;
				}
			}

			Gdx.app.log("INFO", "Tick++");
		}

		if (Gdx.input.isKeyJustPressed(Keys.BACKSPACE)) {
			if (tick > 0) {
				tick--;
			}

			GenericMatrix aux = matrixes.get(tick);
			int index = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					processors.get(index).setValue("" + aux.matrix[i][j]);
					index++;
				}
			}
			Gdx.app.log("INFO", "Tick--");
		}

		if (Gdx.input.isKeyPressed(Keys.Q)) {
			Gdx.app.log("INFO", "Exiting the app");
			Gdx.app.exit();
		}
	}

	public void draw() {
		gameBatch = main.getBatch();
		GL20 gl = Gdx.gl;
		gl.glClearColor(0f, 0f, 0f, 1f);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		for (ProcessorUI p : processors) {
			p.drawProcessor(shapeRenderer);
		}
		shapeRenderer.end();

		gameBatch.enableBlending();
		gameBatch.setProjectionMatrix(camera.combined);
		gameBatch.begin();

		// TEXT ON THE PROCESSORS
		for (ProcessorUI p : processors) {
			if (tick != 7) {
				font16Red.draw(gameBatch, p.getValue(), p.getX() + Config.WORLD_UNIT - Config.WORLD_UNIT / 3,
						p.getY() + Config.WORLD_UNIT + Config.WORLD_UNIT / 3);
			} else {
				font16Blue.draw(gameBatch, p.getValue(), p.getX() + Config.WORLD_UNIT - Config.WORLD_UNIT / 3,
						p.getY() + Config.WORLD_UNIT + Config.WORLD_UNIT / 3);
			}

			// ARROWS LEFT
			gameBatch.draw(arrowLeft, p.getX() - 3 * Config.WORLD_UNIT + Config.WORLD_UNIT / 2,
					p.getY() + Config.WORLD_UNIT / 2);

			// ARROWS UP
			gameBatch.draw(arrowUp, p.getX() + Config.WORLD_UNIT / 2, p.getY() + 3 * Config.WORLD_UNIT);

		}

		// MATRIX A AND MATRIX B
		font16.draw(gameBatch, "Matrix A", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 17 * Config.WORLD_UNIT);
		font16.draw(gameBatch, op.a.toString(), Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 16 * Config.WORLD_UNIT);

		font16.draw(gameBatch, "Matrix B", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 13 * Config.WORLD_UNIT);
		font16.draw(gameBatch, op.b.toString(), Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 12 * Config.WORLD_UNIT);

		// LEGEND
		font16.draw(gameBatch, "Legend", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 6 * Config.WORLD_UNIT);
		font16Red.draw(gameBatch, "RED - Half-sum value", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				5 * Config.WORLD_UNIT);
		font16Blue.draw(gameBatch, "BLUE - Final value", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				4 * Config.WORLD_UNIT);
		font16.draw(gameBatch, "WHITE - Comments/ data", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				3 * Config.WORLD_UNIT);

		// TICKS
		font16.draw(gameBatch, "TICK: " + tick, 2 * Config.WORLD_UNIT, 3 * Config.WORLD_UNIT);
		font16.draw(gameBatch, "Press SPACE for tick", 2 * Config.WORLD_UNIT, 2 * Config.WORLD_UNIT);

		gameBatch.end();

	}

	@Override
	public void render(float delta) {
		update();
		draw();
	}
}

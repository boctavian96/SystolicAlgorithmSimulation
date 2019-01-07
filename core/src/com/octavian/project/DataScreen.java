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
import com.octavian.logic.meta.Column;
import com.octavian.logic.meta.Row;
import com.octavian.ui.ProcessorUI;

public class DataScreen extends AbstractScreen {

	private static final float PROCESSOR_SIZE = 2 * Config.WORLD_UNIT;

	private Systolic main;

	private ShapeRenderer shapeRenderer;
	private List<ProcessorUI> processors;
	private SystolicMatrixMultiplication systolicMultiplication;
	private List<GenericMatrix> matrixState;

	private Texture arrowLeft;
	private Texture arrowUp;

	private List<Row> rows;
	private List<Column> columns;

	private int tick;

	public DataScreen(Systolic main) {
		super();
		this.main = main;
		shapeRenderer = new ShapeRenderer();
		processors = new ArrayList<>();
		systolicMultiplication = new SystolicMatrixMultiplication();
		matrixState = systolicMultiplication.multiplication();

		arrowLeft = new Texture(Gdx.files.internal("lgdxRect.png"));
		arrowUp = new Texture(Gdx.files.internal("lgdxRectUp.png"));

		rows = systolicMultiplication.matrixA.toRows();
		columns = systolicMultiplication.matrixB.toCols();

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
			if (tick < matrixState.size() - 1) {
				tick++;
			}

			GenericMatrix aux = matrixState.get(tick);
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

			GenericMatrix aux = matrixState.get(tick);
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

	public void drawProcessorsAssets() {
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
	}

	private void drawI(String text, float x, float y) {
		if (x > 10f && x < 600f)
			if (tick <= 4) {
				font16Blue.draw(gameBatch, rows.get(0).getValue(4 - tick).toString(), x, y);
			}
	}

	private void drawInput() {
		// ROWS

		List<String> row1 = new ArrayList<>();
		float y;
		float x;

		x = 0f;
		y = 19 * Config.WORLD_UNIT + 5f;

		drawI(rows.get(0).getValue(4).toString(), 2 * Config.WORLD_UNIT, y);
		drawI(rows.get(0).getValue(3).toString(), x, y);
		drawI(rows.get(0).getValue(2).toString(), x, y);
		drawI(rows.get(0).getValue(1).toString(), x, y);
		drawI(rows.get(0).getValue(0).toString(), x, y);

		x = 0f;
		y = 13 * Config.WORLD_UNIT + 5f;

		drawI(rows.get(1).getValue(4).toString(), 2 * Config.WORLD_UNIT, y);
		drawI(rows.get(1).getValue(3).toString(), x, y);
		drawI(rows.get(1).getValue(2).toString(), x, y);
		drawI(rows.get(1).getValue(1).toString(), x, y);
		drawI(rows.get(1).getValue(0).toString(), x, y);

		x = 0f;
		y = 7 * Config.WORLD_UNIT + 5f;

		drawI(rows.get(2).getValue(4).toString(), 2 * Config.WORLD_UNIT, y);
		drawI(rows.get(2).getValue(3).toString(), x, y);
		drawI(rows.get(2).getValue(2).toString(), x, y);
		drawI(rows.get(2).getValue(1).toString(), x, y);
		drawI(rows.get(2).getValue(0).toString(), x, y);

		// COLS
		// font16.draw(gameBatch, columns.get(0).getValue(4), x, y);
		// font16.draw(gameBatch, columns.get(0).getValue(3), x, y);
		// font16.draw(gameBatch, columns.get(0).getValue(2), x, y);
		// font16.draw(gameBatch, columns.get(0).getValue(1), x, y);
		// font16.draw(gameBatch, columns.get(0).getValue(0), x, y);
		//
		// font16.draw(gameBatch, columns.get(1).getValue(4), x, y);
		// font16.draw(gameBatch, columns.get(1).getValue(3), x, y);
		// font16.draw(gameBatch, columns.get(1).getValue(2), x, y);
		// font16.draw(gameBatch, columns.get(1).getValue(1), x, y);
		// font16.draw(gameBatch, columns.get(1).getValue(0), x, y);
		//
		// font16.draw(gameBatch, columns.get(2).getValue(4), x, y);
		// font16.draw(gameBatch, columns.get(2).getValue(3), x, y);
		// font16.draw(gameBatch, columns.get(2).getValue(2), x, y);
		// font16.draw(gameBatch, columns.get(2).getValue(1), x, y);
		// font16.draw(gameBatch, columns.get(2).getValue(0), x, y);

	}

	private void drawMatrix() {
		// MATRIX A AND MATRIX B
		font16.draw(gameBatch, "Matrix A", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 17 * Config.WORLD_UNIT);
		font16.draw(gameBatch, systolicMultiplication.matrixA.toString(), Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				16 * Config.WORLD_UNIT);

		font16.draw(gameBatch, "Matrix B", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 13 * Config.WORLD_UNIT);
		font16.draw(gameBatch, systolicMultiplication.matrixB.toString(), Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				12 * Config.WORLD_UNIT);
	}

	private void drawLegend() {
		// LEGEND
		font16.draw(gameBatch, "Legend", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 6 * Config.WORLD_UNIT);
		font16Red.draw(gameBatch, "RED - Half sum", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT, 5 * Config.WORLD_UNIT);
		font16Blue.draw(gameBatch, "BLUE - Final sum", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				4 * Config.WORLD_UNIT);
		font16.draw(gameBatch, "WHITE - Comments/ data", Config.WORLD_WIDTH - 8 * Config.WORLD_UNIT,
				3 * Config.WORLD_UNIT);

		// TICKS
		font16.draw(gameBatch, "TICK: " + tick, 2 * Config.WORLD_UNIT, 5 * Config.WORLD_UNIT);
		font16.draw(gameBatch, "Press SPACE for tick", 2 * Config.WORLD_UNIT, 4 * Config.WORLD_UNIT);
		font16.draw(gameBatch, "Press BACKSPACE for backward tick", 2 * Config.WORLD_UNIT, 3 * Config.WORLD_UNIT);
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

		drawProcessorsAssets();
		// drawInput();
		drawMatrix();
		drawLegend();

		gameBatch.end();

	}

	@Override
	public void render(float delta) {
		update();
		draw();
	}
}

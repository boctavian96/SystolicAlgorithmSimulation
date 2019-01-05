package com.octavian.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Systolic extends Game {
	private SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	public SpriteBatch getBatch() {
		return this.batch;
	}
}

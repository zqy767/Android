package com.badlogic.androidgames.mrnom;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;
import com.badlogic.androidgames.framework.Screen;

public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
			Graphics g = game.getGraphics();
			Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
			Assets.logo= g.newPixmap("logo.png", PixmapFormat.ARGB4444);
			Assets.mainMenu= g.newPixmap("mainMenu.png", PixmapFormat.ARGB4444);
			Assets.buttons= g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
			Assets.numbers= g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
			Assets.ready= g.newPixmap("ready.png", PixmapFormat.ARGB4444);
			Assets.pause= g.newPixmap("pause.png", PixmapFormat.ARGB4444);
			Assets.gameOver= g.newPixmap("gameOver.png", PixmapFormat.ARGB4444);
			Assets.headUp= g.newPixmap("headUp.png", PixmapFormat.ARGB4444);
			Assets.headLeft= g.newPixmap("headLeft.png", PixmapFormat.ARGB4444);
			Assets.headRight= g.newPixmap("headRight.png", PixmapFormat.ARGB4444);
			Assets.headDown= g.newPixmap("headDown.png", PixmapFormat.ARGB4444);
			Assets.tail= g.newPixmap("tail.png", PixmapFormat.ARGB4444);
			Assets.stain1= g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
			Assets.stain2= g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
			Assets.stain3= g.newPixmap("stain3.png", PixmapFormat.ARGB4444);
			
			Assets.click = game.getAudio().newSound("click.ogg");
			Assets.eat = game.getAudio().newSound("eat.ogg");
			Assets.bitten = game.getAudio().newSound("bitten.ogg");
			Settings.load(game.getFileIO());
			game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reseume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

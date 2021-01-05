package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JPanel;

import gameobject.GameWorld;
import gameobject.PhysicalMap;
import gameobject.Player;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private Thread thread;
	private boolean isRunning;
	
	private InputManager inputManager;
	
	
	private BufferedImage bufImage;
	private Graphics2D bufG2D;
	
	public GameWorld gameWorld;
	
	
	public GamePanel() {
		gameWorld = new GameWorld();
		inputManager = new InputManager(gameWorld);
		bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(bufImage, 0, 0, this);
		
	}
	
	public void UpdateGame() {
		
		gameWorld.Update();
		
	}
	
	public void RenderGame() {
		if(bufImage == null) {
			bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		}
		
		if(bufImage != null) {
			bufG2D = (Graphics2D) bufImage.getGraphics();
		}
		
		if(bufG2D != null) {
			gameWorld.Render(bufG2D);
		}
	}
	
	public void startGame() {
		
		if(thread == null) {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() {
		
		long FPS = 80;
		long period = 1000*1000000/FPS;
		long beginTime;
		long sleepTime;
		
		
		beginTime = System.nanoTime();
		while(isRunning) {
					
			UpdateGame();
			RenderGame();
			repaint();
			
			long deltaTime = System.nanoTime() - beginTime;
			sleepTime = period - deltaTime;
			
			try {
				if(sleepTime > 0)
					Thread.sleep(sleepTime/1000000);
				else Thread.sleep(period/2000000);
			} catch (InterruptedException e) {}
			
			beginTime = System.nanoTime();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
	public void keyPressed(KeyEvent e) {
		inputManager.processKeyPressed(e.getKeyCode());
           
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputManager.processKeyReleased(e.getKeyCode());
		
	}

	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}



}

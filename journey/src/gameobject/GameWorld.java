package gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import userinterface.GameFrame;

public class GameWorld {
	
	public Player player;
	
	public BulletManager bulletManager;
	
	public ParticularObjectManager particularObjectManager;
	public float level = (float) 0.5;;
	//public int score = 1;
	
	PhysicalMap physicalMap;
	
	public static final int BEGIN = 0;
	public static final int STARTGAME = 1;
	public static final int OVER = 2;
	
	private int state = BEGIN;
	
	BufferedImage beginG;
	BufferedImage text;
	
	public GameWorld() {
		player = new Player(250, 250, this);
		player.setTeamType(ParticularObject.LEAGUE_TEAM);
		physicalMap = new PhysicalMap(0, 0, this);
		bulletManager = new BulletManager(this);
		particularObjectManager = new ParticularObjectManager(this);
		
		beginG = ImageLoader.loadImage("/resources/title.png");
		text = ImageLoader.loadImage("/resources/text.png");
	
	}
	
	public void Update() {

		switch (state) {
			case BEGIN:
				
				
			
				break;

			case STARTGAME:
			
				
				player.Update();
				bulletManager.UpdateObjects();
				particularObjectManager.UpdateObjects();
				Level();
				
				break;
			case OVER:
				
				player = new Player(250, 250, this);
				player.setTeamType(ParticularObject.LEAGUE_TEAM);
				physicalMap = new PhysicalMap(0, 0, this);
				bulletManager = new BulletManager(this);
				particularObjectManager = new ParticularObjectManager(this);
				
				level = (float) 0.5;
				//score = 1;
				
				
				
				break;
		}
		
	}

	public void Render(Graphics2D g2) {

		switch(state) {
			case BEGIN:
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
				g2.drawImage(beginG, 100, 170, null);
				
				break;
			case STARTGAME:
							
				physicalMap.draw(g2);
				bulletManager.draw(g2);
				player.draw(g2);
				particularObjectManager.draw(g2);
				
				if(player.getState() == ParticularObject.DEATH) {
					setState(OVER);
				}
				
				break;
			case OVER:
				
				g2.setColor(Color.BLACK);
				g2.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
				g2.drawImage(text, 110, 220, null);
				
				break;
		}

		
	}
	public void Level() {
		
		if(particularObjectManager.getParticularObjectSize()==0) {
			level+=0.3;
			//score+=1;

				particularObjectManager.addObject(new Monster(220, 400, this));
				particularObjectManager.addObject(new Monster(0, 200, this));
				particularObjectManager.addObject(new Monster(220, 0, this));				
				particularObjectManager.addObject(new Monster(480, 240, this));

			for (ParticularObject particularObject : particularObjectManager.getParticularObjects()) {
				particularObject.setTeamType(ParticularObject.ENEMY_TEAM);
				particularObject.setSpeedXY(level,level);
				}
				
		}	
				
	}

//	public Player getPlayer() {
//		return player;
//	}
//
//	public void setPlayer(Player player) {
//		this.player = player;
//	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	}
				


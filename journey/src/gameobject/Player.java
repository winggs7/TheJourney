package gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import effect.CacheDataLoader;


public class Player extends Human{
	

	GameWorld gameWorld;

	BufferedImage img;
	BufferedImage dead;
	
	private long lastShootingTime;
	private boolean isShooting = false;
	
	
	public Player(float x, float y, GameWorld gameWorld) {
		super(x, y, gameWorld );
		this.gameWorld = gameWorld;
		img = ImageLoader.loadImage("/player/player2.png");	
		dead = ImageLoader.loadImage("/resources/player_death/death1.png");
		
	}

	@Override
	public void Update() {
			
		super.Update();
		
		if(isShooting) {
			if(System.nanoTime() - lastShootingTime > 400*1000000) {
				isShooting = false;
			}
		}
		
	}	
	
	@Override
	public void draw(Graphics2D g2) {


		if(getState() == ALIVE) {
			g2.drawImage(img,(int) (getPosX() - (getWidth()/2)), (int) (getPosY() - (getWidth()/2)),null);	
		}
		else if (getState() == DEATH) {
			g2.drawImage(dead,(int) (getPosX() - (getWidth()/2)), (int) (getPosY() - (getWidth()/2)),null);
		}
		

	}

	@Override
	public void attack() {
		
		if(!isShooting) {
			
			Bullet bullet = new Bullet(getPosX(), getPosY(), getGameWorld());

			if(getDirection() == u_DIR) 
			{
				bullet.setSpY(-7);
				bullet.setPosY(bullet.getPosY() + bullet.getSpY());
			}
			else if(getDirection() == d_DIR) 
			{
				bullet.setSpY(7);
				bullet.setPosY(bullet.getPosY() + bullet.getSpY());
			}
			else if(getDirection() == l_DIR) 
			{
				bullet.setSpX(-7);
				bullet.setPosX(bullet.getPosX() + bullet.getSpX());
			}
			else if(getDirection() == r_DIR) 
			{
				bullet.setSpX(7);
				bullet.setPosX(bullet.getPosX() + bullet.getSpX());
			}

			getGameWorld().bulletManager.addObject(bullet);
			
			lastShootingTime = System.nanoTime();
			isShooting = true;
		}
		
	}
	
	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		return getBoundForCollisionWithMap();
	}

	@Override
	public Rectangle getBoundForCollisionWithFriend() {

		return null;
	}

}

package gameobject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;



public class Monster extends ParticularObject {

	BufferedImage monster;
	
    private long startTimeToRun;

	
	public Monster(float x, float y, GameWorld gameWorld) {
		super(x, y, 30, gameWorld);
		monster = ImageLoader.loadImage("/resources/orc.png");
		startTimeToRun = 0;
		setSpeedX(1);
		setSpeedY(1);
	}

	@Override
	public void attack() {

        Bullet bullet = new MonsterManager(getPosX(), getPosY(), getGameWorld());
        
		if(getGameWorld().player.getPosX() - getGameWorld().player.getWidth()/2 > getPosX()) {
			setPosX(getPosX() + getSpeedX());
		}
		if(getGameWorld().player.getPosX() - getGameWorld().player.getWidth()/2 < getPosX()) {
			setPosX(getPosX() - getSpeedX());
		}
		if(getGameWorld().player.getPosY() - getGameWorld().player.getWidth()/2 > getPosY()) {
			setPosY(getPosY() + getSpeedY());
		}
		if(getGameWorld().player.getPosY() - getGameWorld().player.getWidth()/2 < getPosY()) {
			setPosY(getPosY() - getSpeedY());
	}
        
        bullet.setTeamType(getTeamType());
        getGameWorld().bulletManager.addObject(bullet);
		
	}
	
    public void Update(){
        super.Update();
        if(System.nanoTime() - startTimeToRun > 1*10000000){
            attack();
            startTimeToRun = System.nanoTime();
        }
    }

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
        Rectangle rect = getBoundForCollisionWithMap();    
        return rect;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawImage(monster,(int) getPosX(), (int) getPosY(),null);
		
	}

	@Override
	public Rectangle getBoundForCollisionWithFriend() {
        Rectangle rect = getBoundForCollisionWithMap();    
        return rect;
	}
	
	
//	BufferedImage monster;
//
//	public Monster(float x, float y, GameWorld gameWorld) {
//		super(x, y, 30, gameWorld);
//		monster = ImageLoader.loadImage("/resources/orc.png");	
//	}
//	
//	@Override
//	public void Update() {
//			
//		super.Update();
//
//		if(getGameWorld().player.getPosX() > getPosX()) {
//			setPosX(getPosX() + 1);
//		}
//		if(getGameWorld().player.getPosX() < getPosX()) {
//			setPosX(getPosX() - 1);
//		}
//		if(getGameWorld().player.getPosY() > getPosY()) {
//			setPosY(getPosY() + 1);
//		}
//		if(getGameWorld().player.getPosY() < getPosY()) {
//			setPosY(getPosY() - 1);
//		}			
//
//	}
//
//	@Override
//	public void attack() {	
//	}
//
//	@Override
//	public Rectangle getBoundForCollisionWithEnemy() {
//		return getBoundForCollisionWithMap();
//	}
//
//	@Override
//	public void draw(Graphics2D g2) {
//		g2.drawImage(monster,(int) getPosX(), (int) getPosY(),null);		
//	}
//	
//	

}

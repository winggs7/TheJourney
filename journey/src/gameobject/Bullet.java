package gameobject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Bullet extends ParticularObject {
	
	GameWorld gameWorld;
	
	BufferedImage bullet;
	
	public Bullet(float x, float y, GameWorld gameWorld) {
		super(x, y, 7, gameWorld);
		this.gameWorld = gameWorld;
		bullet = ImageLoader.loadImage("/resources/pellet.png");
	}
	
	public void Update() {
		
		super.Update();
		
		setPosX(getPosX() + getSpX());
		setPosY(getPosY() + getSpY());
		
		ParticularObject object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
        if(object!=null && object.getState() == ALIVE){
        	object.setState(DEATH);
        	setState(DEATH);
        	getGameWorld().particularObjectManager.RemoveObject(this);
        }
	}
	
		@Override
	public void draw(Graphics2D g2) {
		g2.drawImage(bullet,(int) (getPosX()), (int) (getPosY() ),null);
		
	}

	@Override
	public void attack() {
		
		
	}

	@Override
	public Rectangle getBoundForCollisionWithEnemy() {
		return getBoundForCollisionWithMap();
	}

	@Override
	public Rectangle getBoundForCollisionWithFriend() {
		// TODO Auto-generated method stub
		return null;
	}

}

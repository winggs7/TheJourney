package gameobject;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;



public abstract class ParticularObject extends GameObject{
	
	public static final int LEAGUE_TEAM = 1;
	public static final int ENEMY_TEAM = 2;

	public static final int l_DIR = 0;
	public static final int r_DIR = 1;
	public static final int u_DIR = 2;
	public static final int d_DIR = 3;
	
	public static final int ALIVE = 0;
	public static final int DEATH = 1;
	private int state = ALIVE;
	
	private float width;
	private float speedX;
	private float speedY;
	
	private float spX;
	private float spY;
	
	private int damage;
	
	private int direction;
	
	private int teamType;
	
	private long startTimeNoBeHurt;
	private long timeForNoBeHurt;

	
	public ParticularObject (float x, float y, float width, GameWorld gameWorld) {
		
		super(x, y, gameWorld);
		setWidth(width);

		
		direction = l_DIR;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getTeamType() {
		return teamType;
	}

	public void setTeamType(int teamType) {
		this.teamType = teamType;
	}

	public long getStartTimeNoBeHurt() {
		return startTimeNoBeHurt;
	}

	public void setStartTimeNoBeHurt(long startTimeNoBeHurt) {
		this.startTimeNoBeHurt = startTimeNoBeHurt;
	}

	public long getTimeForNoBeHurt() {
		return timeForNoBeHurt;
	}

	public void setTimeForNoBeHurt(long timeForNoBeHurt) {
		this.timeForNoBeHurt = timeForNoBeHurt;
	}
	
	public float getSpX() {
		return spX;
	}

	public void setSpX(float spX) {
		this.spX = spX;
	}

	public float getSpY() {
		return spY;
	}

	public void setSpY(float spY) {
		this.spY = spY;
	}

	public abstract void attack();
	
	public Rectangle getBoundForCollisionWithMap() {
		Rectangle bound = new Rectangle();
		bound.x = (int) (getPosX() - (getWidth()/2));
		bound.y = (int) (getPosY() - (getWidth()/2));
		bound.width = (int) getWidth();
		bound.height = (int) getWidth();
		return bound;
	}
	
	public void setSpeedXY(float speedX, float speedY) {
		this.speedX = speedX;
		this.speedY = speedY;
	}
	

	
	@Override
	
	public void Update() {
		switch(state) {
			case ALIVE:
				
				ParticularObject object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
				
				if(object != null) {
					setState(DEATH);
				}
				
				break;
				
			case DEATH:				
				break;
				
		}
			
	}
	
	public void drawBoundForCollisionWithMap(Graphics2D g2) {
		Rectangle rect = getBoundForCollisionWithMap();
  	
	}
	
	public void drawBoundForCollisionWithEnemy(Graphics2D g2) {
		Rectangle rect = getBoundForCollisionWithEnemy();
        
	}
	
	public abstract Rectangle getBoundForCollisionWithEnemy();
	
	public abstract Rectangle getBoundForCollisionWithFriend();
	
	public abstract void draw(Graphics2D g2);
	
	public void hurtingCallback() {};

}


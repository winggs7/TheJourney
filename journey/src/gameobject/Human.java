package gameobject;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import effect.CacheDataLoader;

public abstract class Human extends ParticularObject {
	

	
	public Human(float x, float y, GameWorld gameWorld) {
		super(x, y, 30, gameWorld);
		setState(ALIVE);
	}

	
	@Override
	public void Update() {
		
		super.Update();
		
		if(getState() == ALIVE) {
			
			Rectangle boundForCollisionWithMapFuture = getBoundForCollisionWithMap();
			
			boundForCollisionWithMapFuture.y += (getSpeedY() != 0?getSpeedY() : 2);
			boundForCollisionWithMapFuture.x += (getSpeedX() != 0?getSpeedX() : 2);
			
			Rectangle rectLand = getGameWorld().physicalMap.haveCollisionWithLand(boundForCollisionWithMapFuture);
				
			Rectangle rectTop = getGameWorld().physicalMap.haveCollisionWithTop(boundForCollisionWithMapFuture);
			
			Rectangle rectLeft = getGameWorld().physicalMap.haveCollisionWithLeftWall(boundForCollisionWithMapFuture);
			
			Rectangle rectRight = getGameWorld().physicalMap.haveCollisionWithRightWall(boundForCollisionWithMapFuture);
			
			Rectangle rectBadWall = getGameWorld().physicalMap.haveCollisionWithBadWall(boundForCollisionWithMapFuture);
			
			if(rectTop !=null) {
				
				setSpeedY(0);
				setPosY(rectTop.y + getGameWorld().physicalMap.getTileSize() + getWidth()/2);
					
			}else if(rectLand != null) {

				setSpeedY(0);
				setPosY(getPosY());
				
			}
			if(rectBadWall != null) {

				setSpeedY(0);
				setPosY(getPosY());

			}else setPosY(getPosY() + getSpeedY());
				
			if(rectLeft != null) {
				
				setSpeedX(0);
				setPosX(rectLeft.x + getGameWorld().physicalMap.getTileSize() + getWidth()/2);
			}
			else if (rectRight != null) {
				
				setSpeedX(0);
				setPosX(rectRight.x - getWidth()/2 - 1);	
			}
			else setPosX(getPosX() + getSpeedX());

		}
	}
}

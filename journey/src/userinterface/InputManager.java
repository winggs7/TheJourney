package userinterface;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import gameobject.GameWorld;

public class InputManager {	
	private GameWorld gameWorld;
	
	boolean isRight;
	boolean isLeft ;
	boolean isUp ;
	boolean isDown ;
	private boolean[] keys;
	
	public InputManager(GameWorld gameWorld) {
		
		this.gameWorld = gameWorld;
		keys = new boolean[256];
		
	}
	public void processKeyPressed(int keyCode) {
		if (keyCode==KeyEvent.VK_W) {
			gameWorld.player.setSpeedY(-4);
			isUp = true;
		}
		else if (keyCode==KeyEvent.VK_S){
			gameWorld.player.setSpeedY(4);
			isDown = true;
		}
		else if (keyCode==KeyEvent.VK_A){
			gameWorld.player.setSpeedX(-4);
			isLeft = true;
		}
		else if (keyCode==KeyEvent.VK_D){
			gameWorld.player.setSpeedX(4);
			isRight = true;
		}
		if(keyCode==KeyEvent.VK_UP) {
			gameWorld.player.setDirection(gameWorld.player.u_DIR);
			gameWorld.player.attack();
		}
		if(keyCode==KeyEvent.VK_DOWN) {
			gameWorld.player.setDirection(gameWorld.player.d_DIR);
			gameWorld.player.attack();
		}
		if(keyCode==KeyEvent.VK_LEFT) {
			gameWorld.player.setDirection(gameWorld.player.l_DIR);
			gameWorld.player.attack();
		}
		if(keyCode==KeyEvent.VK_RIGHT) {
			gameWorld.player.setDirection(gameWorld.player.r_DIR);
			gameWorld.player.attack();
		}
		if(keyCode==KeyEvent.VK_ENTER) {
			if(gameWorld.getState() == gameWorld.BEGIN || gameWorld.getState() == gameWorld.OVER) {
				gameWorld.setState(gameWorld.STARTGAME);
			}
			
		}
		
		
	}
	
	public void processKeyReleased(int keyCode) {
		if (keyCode==KeyEvent.VK_W) {
			if(isDown) {
				gameWorld.player.setSpeedY(3);
			}
			else {
				gameWorld.player.setSpeedY(0);
			}
			
			isUp = false;
		}
		else if (keyCode==KeyEvent.VK_S){
			if(isUp) {
				gameWorld.player.setSpeedY(-3);
			}
			else {
				gameWorld.player.setSpeedY(0);
			}
			isDown = false;
		}
		else if (keyCode==KeyEvent.VK_A){
			if(isRight) {
				gameWorld.player.setSpeedX(3);
			}
			else {
				gameWorld.player.setSpeedX(0);
			}
			
			isLeft = false;
		}
		else if (keyCode==KeyEvent.VK_D ){
			if(isLeft) {
				gameWorld.player.setSpeedX(-3);
			}
			else {
				gameWorld.player.setSpeedX(0);
			}
			isRight = false;
		}

		
		
	}

}

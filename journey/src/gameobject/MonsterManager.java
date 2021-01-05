package gameobject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class MonsterManager extends Bullet{

	public MonsterManager(float x, float y, GameWorld gameWorld) {
		super(x, y, gameWorld);
	}
	
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
            return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
    }

    @Override
    public void Update() {
        super.Update();
    }

    @Override
    public void attack() {}
	
//	int level = 0;
//	
//	private ArrayList<Monster> listMonter;
//	private ArrayList<Monster> listMonterDead;
//	
//	public int number;
//	public Random rd;
//
//	private long lastSpawnTime;
//	private boolean spawn = false;
//	
//	Monster m = null;
//
//	public MonsterManager(GameWorld gameWorld) {
//		super(gameWorld);
//		rd = new Random();
//		listMonter = new ArrayList<Monster>();
//		listMonterDead = new ArrayList<Monster>();
//
//	}
//	
//	@Override
//	public void UpdateObjects() {
//		super.UpdateObjects();
//		synchronized (particularObjects) {
//							
//		}
//	
//		if(listMonter.size() == 0 ) {
//			if(System.nanoTime() - lastSpawnTime > 500*1000000) {
//				spawn = false;
//				geneMonster();
//				level ++;
//			}
//		}
//		
//		for(Monster mondead: listMonter) {
//			if(mondead.getState() == 1) {
//				listMonterDead.add(mondead);
//			}
//		}
//		
//		listMonter.removeAll(listMonterDead);
//		
//	}
//	
//	public void geneMonster() {
//		if(!spawn) {
//			for(int i = 0; i <= level; i++) {
//
//				number = rd.nextInt(4);
//
//				if(number == 0) {
//					m = new Monster(0, 220, getGameWorld()); 	
//				}
//				if(number == 1) {
//					m = new Monster(500, 220, getGameWorld());
//				}
//				if(number == 2) {
//					m = new Monster(220, 0, getGameWorld());
//				}
//				if(number == 3) {
//					m = new Monster(224, 400, getGameWorld());
//				}
//				listMonter.add(m);
//				
//				lastSpawnTime = System.nanoTime();
//				
//				getGameWorld().bulletManager.addObject(m);
//				spawn = true;
//				
//				}
//			}
//		}
//		
//	
//	

}

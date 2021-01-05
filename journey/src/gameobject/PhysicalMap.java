package gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import effect.CacheDataLoader;

public class PhysicalMap extends GameObject{
	
	public int [][] phys_map;
	private int tileSize;
	BufferedImage imgbush;
	BufferedImage imgground;
	BufferedImage imginstruc;
	BufferedImage imgground1;
	
	public PhysicalMap(float x, float y, GameWorld gameWorld) {
		super(x, y, gameWorld);
		this.tileSize = 30;
		phys_map = CacheDataLoader.getInstance().getPhysicalMap();
		imgbush = ImageLoader.loadImage("/resources/bush.png");
		imgground = ImageLoader.loadImage("/resources/ground.png");
		imginstruc = ImageLoader.loadImage("/resources/instructions.png");
		imgground1 = ImageLoader.loadImage("/resources/ground1.png");
	}
	
	public int getTileSize() {
		return tileSize;
	}
	
    public Rectangle haveCollisionWithTop(Rectangle rect){
        
        for(int y = phys_map.length - 1; y >= 0; y--){
            for(int x = 0; x < phys_map[0].length; x++){
                
                if(phys_map[y][x] == 1){
                    Rectangle r = new Rectangle((int) getPosX() + x * tileSize, (int) getPosY() + y * tileSize, tileSize, tileSize);
                    if(rect.intersects(r))
                        return r;
                }
            }
        }
        return null;
    }
    
    
    public Rectangle haveCollisionWithLand(Rectangle rect){

        for(int y = 0 ; y < phys_map.length;y++){
            for(int x = 0; x <= phys_map[0].length - 1; x++){
                
                if(phys_map[y][x] == 6){
                    Rectangle r = new Rectangle((int) getPosX() + x * tileSize, (int) getPosY() + y * tileSize, tileSize, tileSize);
                    if(rect.intersects(r))
                        return r;
                }
            }
        }
        return null;
    }
    
    public Rectangle haveCollisionWithRightWall(Rectangle rect){

        for(int x = 0; x <= phys_map[0].length - 1; x++){
            for(int y = 0; y <= phys_map.length - 1;y++){
                if(phys_map[y][x] == 4){
                    Rectangle r = new Rectangle((int) getPosX() + x * tileSize, (int) getPosY() + y * tileSize, tileSize, tileSize);
                    if( rect.intersects(r))
                        return r;
                }
            }
        }
        return null;
        
    }
    
    public Rectangle haveCollisionWithBadWall(Rectangle rect){

        for(int x = 0; x <= phys_map[0].length - 1; x++){
            for(int y = 0; y <= phys_map.length - 1;y++){
                if(phys_map[y][x] == 0){
                    Rectangle r = new Rectangle((int) getPosX() + x * tileSize, (int) getPosY() + y * tileSize, tileSize, tileSize);
                    if( rect.intersects(r))
                        return r;
                }
            }
        }
        return null;
        
    }
    
    public Rectangle haveCollisionWithLeftWall(Rectangle rect){

        for(int x = 0; x <= phys_map[0].length - 1; x++){
            for(int y = 0; y <= phys_map.length - 1;y++){
                if(phys_map[y][x] == 7){
                    Rectangle r = new Rectangle((int) getPosX() + x * tileSize, (int) getPosY() + y * tileSize, tileSize, tileSize);
                    if(rect.intersects(r))
                        return r;
                }
            }
        }
        return null;    
    }
    
    
	@Override
	public void Update() {}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.GRAY);
		for(int i = 0; i< phys_map.length; i++)
			for(int j = 0; j< phys_map[0].length;j++)
				if(phys_map[i][j]==1 || phys_map[i][j]==7|| phys_map[i][j]==4|| phys_map[i][j]==6) 
					g2.drawImage(imgbush,(int) getPosX() + j*tileSize, (int) getPosY() + i*tileSize, tileSize, tileSize,null);
				else if(phys_map[i][j]==2) 
				{
					g2.drawImage(imgground,(int) getPosX() + j*tileSize, (int) getPosY() + i*tileSize, tileSize, tileSize,null);
				}
				else if(phys_map[i][j]==3) 
				{
					g2.drawImage(imginstruc,(int) getPosX() + j*tileSize, (int) getPosY() + i*tileSize, tileSize*4, tileSize*2,null);
					
				}
				else if(phys_map[i][j]==0) 
				{
					g2.fillRect((int) getPosX() + j*tileSize, (int) getPosY() + i*tileSize, tileSize, tileSize);
					
				}
	
				else if(phys_map[i][j]==8) 
				{
					g2.drawImage(imgground1,(int) getPosX() + j*tileSize, (int) getPosY() + i*tileSize, tileSize, tileSize,null);
		
				}
	}

}
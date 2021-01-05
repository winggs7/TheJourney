package gameobject;

import java.awt.Graphics2D;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import effect.CacheDataLoader;


public class ParticularObjectManager {
	
	protected List<ParticularObject> particularObjects;
	
	private GameWorld gameWorld;
	
	public ParticularObjectManager(GameWorld gameWorld) {
		particularObjects = Collections.synchronizedList(new LinkedList<ParticularObject>());
		this.gameWorld = gameWorld;
		
	}
	
	public GameWorld getGameWorld() {
		return gameWorld;
	}

	
	public void addObject(ParticularObject particularObject) {		
		synchronized (particularObject) {
			particularObjects.add(particularObject);
		}
		
	}
	
	public void RemoveObject(ParticularObject particularObject) {
		synchronized (particularObject) {
			
			for(int id = 0; id < particularObjects.size(); id++) {
				
				ParticularObject object = particularObjects.get(id);
				if(object == particularObject )
					particularObjects.remove(id);		
			}
		}
	}
	
	public void UpdateObjects() {
		
		synchronized (particularObjects) {
			for(int id = 0; id < particularObjects.size(); id++) {
				
				ParticularObject object = particularObjects.get(id);
				object.Update();
				if(object.getState() == ParticularObject.DEATH) {
					particularObjects.remove(id);
				}
			}
		}
	}
	
    public ParticularObject getCollisionWidthEnemyObject(ParticularObject object){
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){
                
                ParticularObject objectInList = particularObjects.get(id);

                if(object.getTeamType() != objectInList.getTeamType() && 
                        object.getBoundForCollisionWithEnemy().intersects(objectInList.getBoundForCollisionWithEnemy())){
                	
                    return objectInList;
                }
            }
        }
        return null;
    }
		
	public void draw(Graphics2D g2) {
		synchronized (particularObjects) {
			for(ParticularObject object: particularObjects)
				object.draw(g2);
				
		}
	}
	
	public int getParticularObjectSize() {
		return particularObjects.size();
	}

	public List<ParticularObject> getParticularObjects() {
		return particularObjects;
	}

	
	
}

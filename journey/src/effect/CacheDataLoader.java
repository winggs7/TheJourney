package effect;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class CacheDataLoader {
	
	private static CacheDataLoader instance;
	private String physmapfile = "data/phys_map.txt";
//	private Hashtable<String, Animation> animations;

	private int[][] phys_map;
	
	private CacheDataLoader() {
		
	}
	
	public static CacheDataLoader getInstance() {
		
		if(instance == null)
			instance = new CacheDataLoader();
		return instance;
		
	}
	
	public void LoadData()throws IOException{
		 
        LoadPhysMap();
 
    }
	
	public int[][] getPhysicalMap(){
		return instance.phys_map;
	}

	public void LoadPhysMap() throws IOException{
		 
        FileReader fr = new FileReader(physmapfile);
        BufferedReader br = new BufferedReader(fr);
 
        String line = null;
 
        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);
 
        instance.phys_map = new int[numberOfRows][numberOfColumns];
 
        for(int i = 0;i < numberOfRows;i++){
            line = br.readLine();
            String [] str = line.split(" ");
            for(int j = 0;j < numberOfColumns;j++)
                instance.phys_map[i][j] = Integer.parseInt(str[j]);
        }
 
//        for(int i = 0;i < numberOfRows;i++){
// 
//            for(int j = 0;j < numberOfColumns;j++)
//                System.out.print(" "+instance.phys_map[i][j]);
// 
//            System.out.println();
//        }
 
        br.close();
 
    }
	
	
	
}

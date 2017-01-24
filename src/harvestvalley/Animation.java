/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harvestvalley;

/**
 *
 * @author Fanni
 */

import java.awt.Image;
import java.util.ArrayList;

public class Animation {
    private ArrayList scenes;
    private int sceneIndex;
    private long movieTime;
    private long totalTime;
    
    //Konstruktor
    public Animation(){
        scenes = new ArrayList();
        totalTime = 0;
        start();
    }
    
    //add scene to ArrayList and set for each scene
    public synchronized void addScene(Image i, long t){
        totalTime += t;
        scenes.add(new OneScene(i, totalTime));
    }
    
    public synchronized void start(){
        movieTime = 0;
        sceneIndex = 0;
    }
    
    // change scenes
    public synchronized void update(long timePassed){
        if(scenes.size()>1){
            movieTime += timePassed;
            if(movieTime >= totalTime){
                movieTime = 0;
                sceneIndex = 0;
            }
            while(movieTime > getScene(sceneIndex).endTime){
                sceneIndex++;
            }
        }
    }
    
    //get image
    public synchronized Image getImage(){
        if(scenes.size()==0){
            return null;
        }else{
            return getScene(sceneIndex).pic;
        }
    }
    
    //get scene
    private OneScene getScene(int x){
        return (OneScene)scenes.get(x);
    }
    
   ///PRIVATE INNER CLASS 
    private class OneScene{
        Image pic;
        long endTime;
        
        public OneScene(Image pic, long endTime){
            this.pic = pic;
            this.endTime = endTime;
        }
    }
}

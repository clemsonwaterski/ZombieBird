package com.tigerstripestech.GameObjects;

/**
 * Created by Josh on 7/20/2014.
 */
public class Grass extends Scrollable {

    public Grass(float x, float y, int width, int height, float scrollSpeed){
        super(x,y,width,height,scrollSpeed);
    }

    public void onRestart(float x, int scrollSpeed) {
        position.x = x;
        velocity.x = scrollSpeed;
    }
}

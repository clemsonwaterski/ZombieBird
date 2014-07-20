package com.tigerstripestech.GameObjects;

import java.util.Random;

/**
 * Created by Josh on 7/20/2014.
 */
public class Pipe extends Scrollable {
    private Random r;

    public Pipe(float x, float y, int width, int height, float scrollSpeed ){
        super(x,y,width,height,scrollSpeed);
        r = new Random();
    }

    @Override
    public void reset(float newX){
        super.reset(newX);
        height = r.nextInt(90) + 15;
    }
}

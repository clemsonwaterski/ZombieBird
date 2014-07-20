package com.tigerstripestech.GameObjects;

/**
 * Created by Josh on 7/20/2014.
 */
public class ScrollHandler {
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3;

    public static final int SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 49;

    public ScrollHandler(float yPos){
    }

    public void update(float delta){

    }

    public Grass getFrontGrass(){
        return frontGrass;
    }

    public Grass getBackGrass(){
        return backGrass;
    }

    public Pipe getPipe1(){
        return pipe1;
    }

    public Pipe getPipe2(){
        return pipe2;
    }

    public Pipe getPipe3(){
        return pipe3;
    }
}

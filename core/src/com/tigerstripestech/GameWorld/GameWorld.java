package com.tigerstripestech.GameWorld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.tigerstripestech.GameObjects.Bird;
import com.tigerstripestech.GameObjects.ScrollHandler;
import com.tigerstripestech.ZBHelpers.AssetLoader;

/**
 * Created by Josh on 7/10/2014.
 */
public class GameWorld {

    //private Rectangle rect = new Rectangle(0, 0,17,12);  Day 4 rectangle code
    private Bird bird;
    private ScrollHandler scroller;
    private int midPointY;

    private Rectangle ground;

    private int score = 0;

    public enum GameState{
        READY, RUNNING, GAMEOVER
    }

    private GameState currentState;


    public GameWorld(int midPointY){
        currentState = GameState.READY;
        this.midPointY = midPointY;

        this.bird = new Bird(33, midPointY - 5, 17, 12);

        // the grass should start 66 pixels below the midPointY
        this.scroller = new ScrollHandler(this, midPointY + 66);

        ground = new Rectangle(0, midPointY + 66, 136, 11);


    }

    public void update(float delta){
        switch(currentState){
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
            default:
                updateRunning(delta);
        }
    }

    public void updateReady(float delta){

    }

    public void updateRunning(float delta) {

        if (delta > .15f){
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if(bird.isAlive() && scroller.collides(bird)){
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if(Intersector.overlaps(bird.getBoundingCircle(), ground)){
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;
        }
    }

    public Bird getBird(){
        return bird;
    }

    public ScrollHandler getScroller(){
        return scroller;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment){
        score += increment;
    }

    public boolean isReady(){
        return currentState == GameState.READY;
    }

    public void start(){
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver(){
        return currentState == GameState.GAMEOVER;
    }

}

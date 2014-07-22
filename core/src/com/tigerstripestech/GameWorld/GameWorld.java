package com.tigerstripestech.GameWorld;

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

    private boolean isAlive = true;

    public GameWorld(int midPointY){
        this.bird = new Bird(33, midPointY - 5, 17, 12);

        // the grass should start 66 pixels below the midPointY
        this.scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        /* Day 4 rectangle code
        System.out.println("GameWorld - update");
        rect.x++;
        rect.y++;
        if(rect.x > 137) {
            rect.x = 0;
            rect.y = 0;
        }
        if(rect.y > 205) {
            rect.y = 0;
            rect.y = 0;
        }
        */

        bird.update(delta);
        scroller.update(delta);

        if(isAlive && scroller.collides(bird)){
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        }
    }

    public Bird getBird(){
        return bird;
    }

    public ScrollHandler getScroller(){
        return scroller;
    }

    /* Day 4 rectangle code
    public Rectangle getRect(){
        return rect;
    }
    */

}
